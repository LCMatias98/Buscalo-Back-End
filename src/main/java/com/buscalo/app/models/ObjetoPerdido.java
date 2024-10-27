package com.buscalo.app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import java.time.LocalDateTime;

@Document(collection = "objetos_perdidos")
public class ObjetoPerdido {

    @Id
    private Long id;

    @Indexed
    private String titulo; // Breve descripción o título del objeto

    private String descripcion;

    private String categoria; // Categoría del objeto, opcional para la funcionalidad de búsqueda

    @Indexed
    private LocalDateTime fechaPerdido; // Fecha en que el objeto se perdió

    private Ubicacion ubicacion; // Dirección o zona donde se perdió el objeto

    @DBRef // Relación con el usuario que perdió el objeto
    private Usuario usuario;

    private Recompensa recompensa; // Si el usuario ofrece recompensa o no
    // Dirección o zona donde se encontró el objeto


    // Constructor vacío
    public ObjetoPerdido() {
    }

    // Constructor con parámetros
    public ObjetoPerdido(String titulo, String descripcion, String categoria, LocalDateTime fechaPerdido, Ubicacion ubicacion, Usuario usuario, Recompensa recompensa) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.fechaPerdido = fechaPerdido;
        this.ubicacion = ubicacion;
        this.usuario = usuario;
        this.recompensa = recompensa;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDateTime getFechaPerdido() {
        return fechaPerdido;
    }

    public void setFechaPerdido(LocalDateTime fechaPerdido) {
        this.fechaPerdido = fechaPerdido;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Recompensa isRecompensa() {
        return recompensa;
    }

    public void setRecompensa(Recompensa recompensa) {
        this.recompensa = recompensa;
    }
}
