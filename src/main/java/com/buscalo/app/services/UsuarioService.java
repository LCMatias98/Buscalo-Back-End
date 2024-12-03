package com.buscalo.app.services;

import com.buscalo.app.controllers.UserLoginRequestDTO;
import com.buscalo.app.models.ObjetoEncontrado;
import com.buscalo.app.models.Usuario;
import com.buscalo.app.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private  UsuarioRepository usuarioRepository;


    public Usuario autenticarUsuario(UserLoginRequestDTO userLoginRequestDTO) {
        // Buscar al usuario por correo en la base de datos
        Usuario usuarioExistente = usuarioRepository.findByEmail(userLoginRequestDTO.getEmail());

        if (usuarioExistente != null) {
            // Verificar si el token es igual o si ha caducado
            if (!usuarioExistente.getToken().equals(userLoginRequestDTO.getToken())) {
                // Intentar renovar el token usando el refresh token
                String nuevoToken = refreshAccessToken(usuarioExistente.getRefreshToken());
                usuarioExistente.setToken(nuevoToken); // Guardar el nuevo token
                usuarioRepository.save(usuarioExistente);
                // Devolver el usuario con el token actualizado
            }
            return usuarioExistente;
        } else {
            // Si el usuario no existe, crea uno nuevo
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setNombre(userLoginRequestDTO.getName());
            nuevoUsuario.setEmail(userLoginRequestDTO.getEmail());
            nuevoUsuario.setToken(userLoginRequestDTO.getToken());
            nuevoUsuario.setRefreshToken(generateRefreshToken());
            return usuarioRepository.save(nuevoUsuario);
        }
    }


    //Método para generar un refresh token único
    private String generateRefreshToken() {
        return UUID.randomUUID().toString();
    }

    // Método para validar el refresh token y generar un nuevo access token
    public String refreshAccessToken(String refreshToken) {
        Usuario usuario = usuarioRepository.findByRefreshToken(refreshToken);
        if (usuario != null) {
            // Generar un nuevo access token y guardarlo
            String newAccessToken = UUID.randomUUID().toString(); // Puedes generar el token como necesites
            usuario.setToken(newAccessToken);
            usuarioRepository.save(usuario);
            return newAccessToken;
        } else {
            throw new RuntimeException("Refresh token inválido");
        }
    }

    public Usuario obtenerPorId(String id) {
        return usuarioRepository.findById(id).orElse(null);
    }
}