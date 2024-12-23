package com.buscalo.app.repositories;

import com.buscalo.app.models.ObjetoPerdido;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ObjetoPerdidoRepository extends MongoRepository<ObjetoPerdido, Long> {

}
