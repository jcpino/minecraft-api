package com.jcpino.primerapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "jugadores")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String rango;
    private String ultimaConexion;

    // LA NUEVA VARIABLE:
    private boolean baneado;

    public Jugador() {}

    public Jugador(String nombre, String rango, String ultimaConexion) {
        this.nombre = nombre;
        this.rango = rango;
        this.ultimaConexion = ultimaConexion;
        this.baneado = false; // Por defecto, todos entran sin ban
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getRango() { return rango; }
    public void setRango(String rango) { this.rango = rango; }

    public String getUltimaConexion() { return ultimaConexion; }
    public void setUltimaConexion(String ultimaConexion) { this.ultimaConexion = ultimaConexion; }

    // NUEVOS MÉTODOS:
    public boolean isBaneado() { return baneado; }
    public void setBaneado(boolean baneado) { this.baneado = baneado; }
}