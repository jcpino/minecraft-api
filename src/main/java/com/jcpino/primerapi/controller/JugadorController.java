package com.jcpino.primerapi.controller;

import com.jcpino.primerapi.model.Jugador;
import com.jcpino.primerapi.service.JugadorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // "Soy un bloque de comandos que responde peticiones web (JSON)"
@RequestMapping("/api/jugadores") // La ruta base (como si fuera /api/jugadores)
@CrossOrigin(origins = "*")
public class JugadorController {

    private final JugadorService jugadorService;

    // Le decimos al Controlador quién es el Moderador (Service)
    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    // 1. LEER TODOS (GET) - Trae la lista completa de jugadores
    @GetMapping
    public List<Jugador> listarTodos() {
        return jugadorService.obtenerTodos();
    }

    // 2. LEER POR NOMBRE (GET) - Busca a un jugador específico
    @GetMapping("/{nombre}")
    public Jugador buscarJugador(@PathVariable String nombre) {
        return jugadorService.buscarPorNombre(nombre);
    }

    // 3. CREAR (POST) - Para que Angular envíe un jugador nuevo al servidor
    @PostMapping
    public Jugador crearJugador(@RequestBody Jugador nuevoJugador) {
        return jugadorService.guardarJugador(nuevoJugador);
    }

    // 4. BANEAR (PUT) - http://localhost:8080/api/jugadores/3/banear
    @PutMapping("/{id}/banear")
    public Jugador banearJugador(@PathVariable Long id) {
        return jugadorService.banearJugador(id);
    }
}