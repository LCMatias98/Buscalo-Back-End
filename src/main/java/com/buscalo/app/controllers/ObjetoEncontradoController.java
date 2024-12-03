package com.buscalo.app.controllers;

import com.buscalo.app.dtos.ObjetoEncontradoDTO;
import com.buscalo.app.models.Categoria;
import com.buscalo.app.models.ObjetoEncontrado;
import com.buscalo.app.models.Usuario;
import com.buscalo.app.services.CategoriaService; // Asegúrate de tener un servicio para acceder a la categoría
import com.buscalo.app.services.UsuarioService; // Asegúrate de tener un servicio para acceder al usuario
import com.buscalo.app.services.ObjetoEncontradoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/objetos-encontrados")
public class ObjetoEncontradoController {

    @Autowired
    private ObjetoEncontradoService objetoEncontradoService;

    @Autowired
    private CategoriaService categoriaService; // Servicio para manejar categorías

    @Autowired
    private UsuarioService usuarioService; // Servicio para manejar usuarios

    @PostMapping
    public ResponseEntity<ObjetoEncontrado> registrarObjeto(@RequestBody ObjetoEncontradoDTO objetoDTO) {
        ObjetoEncontrado objeto = convertirDTOaEntidad(objetoDTO);
        ObjetoEncontrado nuevoObjeto = objetoEncontradoService.guardarObjeto(objeto);
        return ResponseEntity.ok(nuevoObjeto);
    }

    @GetMapping
    public ResponseEntity<List<ObjetoEncontrado>> listarObjetos() {
        return ResponseEntity.ok(objetoEncontradoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObjetoEncontrado> obtenerObjeto(@PathVariable String id) {
        ObjetoEncontrado objeto = objetoEncontradoService.obtenerPorId(id);
        if (objeto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(objeto);
    }

    // Método utilitario para convertir el DTO a la entidad
    private ObjetoEncontrado convertirDTOaEntidad(ObjetoEncontradoDTO dto) {
        ObjetoEncontrado objeto = new ObjetoEncontrado();
        objeto.setTitulo(dto.getTitulo());
        objeto.setDescripcion(dto.getDescripcion());
        objeto.setFechaEncontrado(dto.getFechaEncontrado());
        objeto.setUbicacion(dto.getUbicacion());

        // Buscar el usuario por ID
        Usuario usuario = usuarioService.obtenerPorId(dto.getUsuario().getId());
        objeto.setUsuario(usuario);

        // Buscar la categoría por ID
        Categoria categoria = categoriaService.obtenerPorId(dto.getCategoria().getId());
        objeto.setCategoria(categoria);

        objeto.setRecompensa(dto.getRecompensa());

        return objeto;
    }
}

