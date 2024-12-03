package com.buscalo.app.repositories;

import com.buscalo.app.models.ObjetoPerdido;
import com.buscalo.app.models.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UsuarioRepository extends MongoRepository<Usuario, String>{

    Usuario findByEmail (String email);

    Usuario findByRefreshToken(String refreshToken);

}
