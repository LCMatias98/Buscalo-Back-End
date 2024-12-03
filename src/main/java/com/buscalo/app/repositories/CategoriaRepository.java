package com.buscalo.app.repositories;

import com.buscalo.app.models.Categoria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CategoriaRepository extends MongoRepository<Categoria, String> {
}
