package com.buscalo.app.services;

import com.buscalo.app.models.ObjetoEncontrado;
import com.buscalo.app.repositories.ObjetoEncontradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjetoEncontradoService {

    @Autowired
    private ObjetoEncontradoRepository repository;

    public ObjetoEncontrado guardarObjeto(ObjetoEncontrado objeto) {
        return repository.save(objeto);
    }

    public List<ObjetoEncontrado> obtenerTodos() {
        return repository.findAll();
    }

    public ObjetoEncontrado obtenerPorId(String id) {
        return repository.findById(id).orElse(null);
    }
}
