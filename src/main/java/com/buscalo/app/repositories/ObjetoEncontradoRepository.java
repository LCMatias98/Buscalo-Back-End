package com.buscalo.app.repositories;

import com.buscalo.app.models.ObjetoEncontrado;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ObjetoEncontradoRepository extends MongoRepository<ObjetoEncontrado, String> {
}
