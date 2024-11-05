package com.buscalo.app.controllers;

import com.buscalo.app.models.ObjetoPerdido;
import com.buscalo.app.models.Recompensa;
import com.buscalo.app.models.Ubicacion;
import com.buscalo.app.models.Usuario;
import com.buscalo.app.repositories.ObjetoPerdidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class ObjetoPerdidoController {

    @Autowired
    ObjetoPerdidoRepository objetoPerdidoRepository;

    @PostMapping(path = "/ObjetoPerdido/Guardar")
    public void guardarObjetoPerdido() {
        ObjetoPerdido objeto = new ObjetoPerdido("Título", "Descripción", "Categoría", LocalDateTime.now());
        objetoPerdidoRepository.save(objeto);
    }
}
