package com.jcpino.primerapi.model;

import jakarta.persistence.*;

@Entity // Le dice a Spring: "Esto es un archivo de guardado (tabla) en MySQL"
@Table(name = "jugadores") // El nombre de la tabla en la base de datos
public class Jugador {

    @Id // La llave primaria (el ID único del jugador)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Se auto-incrementa (1, 2, 3...)
    private Long id;

    private String nombre; // Ej: "Steve"

    private String rango; // Ej: "VIP", "ADMIN", "JUGADOR"

    private String ultimaConexion; // Ej: "2023-10-27 15:30:00" (Lo dejamos como texto para no enredarnos ahora)

    // Constructor vacío (Obligatorio para que JPA pueda leer el archivo)
    public Jugador() {}

    // Constructor para crear un jugador rápido
    public Jugador(String nombre, String rango, String ultimaConexion) {
        this.nombre = nombre;
        this.rango = rango;
        this.ultimaConexion = ultimaConexion;
    }

    // Getters y Setters (Para que el resto del sistema pueda leer y modificar estos datos)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getRango() { return rango; }
    public void setRango(String rango) { this.rango = rango; }

    public String getUltimaConexion() { return ultimaConexion; }
    public void setUltimaConexion(String ultimaConexion) { this.ultimaConexion = ultimaConexion; }
}