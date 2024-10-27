package com.buscalo.app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Document(collection = "categorias")
public class Categoria {

    @Id
    private String id;

    @Indexed(unique = true)
    private String nombre; // Nombre de la categoría

    @DBRef
    private List<ObjetoPerdido> objetosPerdidos; // Relación con objetos perdidos

    // Constructor vacío
    public Categoria() {}

    // Constructor con parámetros
    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<ObjetoPerdido> getObjetosPerdidos() {
        return objetosPerdidos;
    }

    public void setObjetosPerdidos(List<ObjetoPerdido> objetosPerdidos) {
        this.objetosPerdidos = objetosPerdidos;
    }
}
