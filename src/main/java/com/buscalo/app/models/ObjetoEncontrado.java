package com.buscalo.app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import java.time.LocalDateTime;

@Document(collection = "objetos_encontrados")
public class ObjetoEncontrado {

    @Id
    private Long id;

    @Indexed
    private String titulo; // Breve descripción o título del objeto

    private String descripcion;

    @DBRef // Relación con la categoría del objeto
    private Categoria categoria;


    @Indexed
    private LocalDateTime fechaEncontrado; // Fecha en que el objeto fue encontrado

    private Ubicacion ubicacion; // Dirección o zona donde se encontró el objeto

    @DBRef // Relación con el usuario que encontró el objeto
    private Usuario usuario;

    private Recompensa recompensa; // Si el usuario ofrece recompensa o no

    // Constructor vacío
    public ObjetoEncontrado() {
    }

    // Constructor con parámetros
    public ObjetoEncontrado(String titulo, String descripcion, Categoria categoria, LocalDateTime fechaEncontrado, Ubicacion ubicacion, Usuario usuario, Recompensa recompensa) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.fechaEncontrado = fechaEncontrado;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public LocalDateTime getFechaEncontrado() {
        return fechaEncontrado;
    }

    public void setFechaEncontrado(LocalDateTime fechaEncontrado) {
        this.fechaEncontrado = fechaEncontrado;
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

    public Recompensa getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(Recompensa recompensa) {
        this.recompensa = recompensa;
    }
}
