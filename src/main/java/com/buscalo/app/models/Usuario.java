package com.buscalo.app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Document(collection = "usuarios")
public class Usuario {

    @Id
    private String id;

    @Indexed(unique = true)
    private String email;

    private String nombre;
    private String apellido;
    private String password;
    private String telefono;
    private String token;
    private String refreshToken;

    private Boolean esActivo; // Estado de cuenta
    private Boolean recibirNotificaciones; // Preferencias del usuario sobre notificaciones

    @DBRef // Referencia a objetos perdidos
    private List<ObjetoPerdido> objetosPerdidos;

    @DBRef // Referencia a objetos encontrados
    private List<ObjetoEncontrado> objetosEncontrados;

    // Constructor vacío
    public Usuario() {
    }

    // Constructor con parámetros
    public Usuario(String email, String nombre, String apellido, String password, String telefono,
                   Boolean esActivo, Boolean recibirNotificaciones, List<ObjetoPerdido> objetosPerdidos,
                   List<ObjetoEncontrado> objetosEncontrados) {
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.telefono = telefono;
        this.esActivo = esActivo;
        this.recibirNotificaciones = recibirNotificaciones;
        this.objetosPerdidos = objetosPerdidos;
        this.objetosEncontrados = objetosEncontrados;
    }

    // Getters y Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getEsActivo() {
        return esActivo;
    }

    public void setEsActivo(Boolean esActivo) {
        this.esActivo = esActivo;
    }

    public Boolean getRecibirNotificaciones() {
        return recibirNotificaciones;
    }

    public void setRecibirNotificaciones(Boolean recibirNotificaciones) {
        this.recibirNotificaciones = recibirNotificaciones;
    }

    public List<ObjetoPerdido> getObjetosPerdidos() {
        return objetosPerdidos;
    }

    public void setObjetosPerdidos(List<ObjetoPerdido> objetosPerdidos) {
        this.objetosPerdidos = objetosPerdidos;
    }

    public List<ObjetoEncontrado> getObjetosEncontrados() {
        return objetosEncontrados;
    }

    public void setObjetosEncontrados(List<ObjetoEncontrado> objetosEncontrados) {
        this.objetosEncontrados = objetosEncontrados;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
