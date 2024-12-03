package com.buscalo.app.services;

import com.buscalo.app.models.Categoria;
import com.buscalo.app.models.ObjetoEncontrado;
import com.buscalo.app.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    public Categoria obtenerPorId(String id) {
        return categoriaRepository.findById(id).orElse(null);
    }
}
