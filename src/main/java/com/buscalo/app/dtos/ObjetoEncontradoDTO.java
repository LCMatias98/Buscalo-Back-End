package com.buscalo.app.dtos;

import com.buscalo.app.models.*;

import java.time.LocalDateTime;

public class ObjetoEncontradoDTO {

    private String titulo;
    private String descripcion;
    private Categoria categoria;
    private LocalDateTime fechaEncontrado;
    private Ubicacion ubicacion;
    private Usuario usuario;
    private Recompensa recompensa;

    // Constructor vacío
    public ObjetoEncontradoDTO() {
    }

    public ObjetoEncontradoDTO(ObjetoEncontrado objetoEncontrado){
        this.titulo = objetoEncontrado.getTitulo();
        this.descripcion = objetoEncontrado.getDescripcion();
        this.categoria = objetoEncontrado.getCategoria();
        this.fechaEncontrado = objetoEncontrado.getFechaEncontrado();
        this.ubicacion = objetoEncontrado.getUbicacion();
        this.usuario = objetoEncontrado.getUsuario();
        this.recompensa = objetoEncontrado.getRecompensa();
    }

    // Constructor con parámetros
    public ObjetoEncontradoDTO(String titulo, String descripcion, Categoria categoria, LocalDateTime fechaEncontrado,
                               Ubicacion ubicacion, Usuario usuario, Recompensa recompensa) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.fechaEncontrado = fechaEncontrado;
        this.ubicacion = ubicacion;
        this.usuario = usuario;
        this.recompensa = recompensa;
    }

    // Getters y Setters

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
