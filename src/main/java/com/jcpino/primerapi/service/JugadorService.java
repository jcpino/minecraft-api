package com.jcpino.primerapi.service;

import com.jcpino.primerapi.model.Jugador;
import com.jcpino.primerapi.repository.JugadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Le dice a Spring: "Soy el moderador, encárgate de mí"
public class JugadorService {

    private final JugadorRepository jugadorRepository;

    // Inyección de dependencias (Le damos el plugin de base de datos al moderador)
    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    // 1. Traer a todos los jugadores (para un panel de administración)
    public List<Jugador> obtenerTodos() {
        return jugadorRepository.findAll();
    }

    // 2. Buscar por nombre (Tu lógica exacta)
    public Jugador buscarPorNombre(String nombre) {
        // El repositorio busca. Si no lo encuentra, devuelve null.
        Jugador jugador = jugadorRepository.findByNombre(nombre);

        // Aquí aplicas tu regla de negocio:
        if (jugador == null) {
            // En el futuro, aquí lanzaremos una alerta (Exception) para que el frontend sepa que hubo error.
            System.out.println("¡Alerta! El jugador " + nombre + " no existe en la base de datos.");
            return null;
        }

        // Si existe, lo devuelve
        return jugador;
    }

    // 3. Guardar un jugador (El plugin lo manda cada vez que alguien entra)
    public Jugador guardarJugador(Jugador jugadorNuevo) {
        // Primero, revisamos si el jugador ya existe en la base de datos por su nombre
        Jugador jugadorExistente = jugadorRepository.findByNombre(jugadorNuevo.getNombre());

        if (jugadorExistente != null) {
            // REGLA DE NEGOCIO 1: Si ya existe, conservamos su rango real (VIP, ADMIN, etc.)
            jugadorNuevo.setRango(jugadorExistente.getRango());
            // REGLA DE NEGOCIO 2: Le actualizamos el ID para que no cree un duplicado
            jugadorNuevo.setId(jugadorExistente.getId());
        } else {
            // REGLA DE NEGOCIO 3: Si es nuevo, forzamos que sea JUGADOR sin importar lo que diga el plugin
            jugadorNuevo.setRango("JUGADOR");
        }

        // Finalmente, el repositorio hace el INSERT (si es nuevo) o el UPDATE (si ya existía)
        return jugadorRepository.save(jugadorNuevo);
    }

    public Jugador banearJugador(Long id) {
        return jugadorRepository.findById(id).map(jugador -> {
            jugador.setBaneado(true); // Lo marcamos como baneado en MySQL
            // Opcional: Podrías cambiarle el rango a "BANEADO" visualmente
            // jugador.setRango("BANEADO");
            return jugadorRepository.save(jugador);
        }).orElse(null);
    }
}