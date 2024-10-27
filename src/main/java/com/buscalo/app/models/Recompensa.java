package com.buscalo.app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Document(collection = "recompensas")
public class Recompensa {

    @Id
    private Long id;

    @DBRef // Relación con el objeto perdido
    private ObjetoPerdido objetoPerdido;

    @DBRef // Relación con el usuario que ofrece la recompensa
    private Usuario usuario;

    private Double monto; // Monto de la recompensa
    private String mensaje; // Mensaje opcional del usuario que ofrece la recompensa

    // Constructor vacío
    public Recompensa() {
    }

    // Constructor con parámetros
    public Recompensa(ObjetoPerdido objetoPerdido, Usuario usuario, Double monto, String mensaje) {
        this.objetoPerdido = objetoPerdido;
        this.usuario = usuario;
        this.monto = monto;
        this.mensaje = mensaje;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ObjetoPerdido getObjetoPerdido() {
        return objetoPerdido;
    }

    public void setObjetoPerdido(ObjetoPerdido objetoPerdido) {
        this.objetoPerdido = objetoPerdido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
