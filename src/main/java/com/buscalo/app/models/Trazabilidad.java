package com.buscalo.app.models;

import com.buscalo.app.models.Enums.EstadoTrazabilidad;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "trazabilidades")
public class Trazabilidad {

    @Id
    private Long id;

    @DBRef
    private ObjetoPerdido objetoPerdido; // Relación con el objeto perdido al que se le realiza el seguimiento

    private LocalDateTime fecha; // Fecha del registro de la trazabilidad

    private EstadoTrazabilidad estado; // Estado actual del objeto (ej. "En búsqueda", "Encontrado", "Entregado", etc.)

    private String ubicacionActual; // Ubicación actual del objeto, si se conoce

    // Constructor vacío
    public Trazabilidad() {}

    // Constructor con parámetros
    public Trazabilidad(ObjetoPerdido objetoPerdido, LocalDateTime fecha, EstadoTrazabilidad estado, String ubicacionActual) {
        this.objetoPerdido = objetoPerdido;
        this.fecha = fecha;
        this.estado = estado;
        this.ubicacionActual = ubicacionActual;
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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public EstadoTrazabilidad getEstado() {
        return estado;
    }

    public void setEstado(EstadoTrazabilidad estado) {
        this.estado = estado;
    }

    public String getUbicacionActual() {
        return ubicacionActual;
    }

    public void setUbicacionActual(String ubicacionActual) {
        this.ubicacionActual = ubicacionActual;
    }
}
