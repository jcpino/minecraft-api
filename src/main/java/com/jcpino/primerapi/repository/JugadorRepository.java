package com.jcpino.primerapi.repository;

import com.jcpino.primerapi.model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {

    // ¡Magia! No necesitas escribir nada más aquí.
    // Al heredar de JpaRepository, Spring ya te regala los métodos:
    // - save() -> Para guardar o actualizar un jugador.
    // - findAll() -> Para traer a todos los jugadores.
    // - findById() -> Para buscar a un jugador por su ID.
    // - deleteById() -> Para borrar a un jugador.

    // (Opcional) Si quieres buscar por nombre exacto, solo escribes esta línea:
    Jugador findByNombre(String nombre);
}