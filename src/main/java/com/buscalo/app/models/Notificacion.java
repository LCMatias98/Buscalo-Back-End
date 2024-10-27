package com.buscalo.app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notificaciones")
public class Notificacion {

    @Id
    private Long id;

    private String mensaje; // Mensaje de la notificación

    @DBRef
    private Usuario usuario; // Relación con el usuario que recibe la notificación

    private Boolean leida; // Estado de lectura de la notificación

    // Constructor vacío
    public Notificacion() {}

    // Constructor con parámetros
    public Notificacion(String mensaje, Usuario usuario, Boolean leida) {
        this.mensaje = mensaje;
        this.usuario = usuario;
        this.leida = leida;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Boolean getLeida() {
        return leida;
    }

    public void setLeida(Boolean leida) {
        this.leida = leida;
    }
}
