package com.hotels17.backendproyecto.controlador;

import com.hotels17.backendproyecto.modelo.*;
import com.hotels17.backendproyecto.servicio.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/hoteles")
public class HotelesControlador {

    @Autowired
    private Servicio servicio;

    @GetMapping()
    public List<Hotel> getHoteles() {
        return servicio.getHoteles();
    }

    @GetMapping("//pais/{pais}")
    public List<Hotel> getHotelesPorPais(@PathVariable String pais) {
        return servicio.getHotelesPorPais(pais);
    }

    @GetMapping("/ciudad/{ciudad}")
    public List<Hotel> getHotelesPorCiudad(@PathVariable String ciudad) {
        return servicio.getHotelesPorCiudad(ciudad);
    }

    @GetMapping("/{idHotel}")
    public ResponseEntity<Hotel> getHotel(@PathVariable Integer idHotel) {
        Hotel hotel = servicio.getHotel(idHotel);

        if (hotel == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(hotel);
    }

    @GetMapping("/{idHotel}/fotos")
    public ResponseEntity<List<Foto>> getFotosHotel(@PathVariable Integer idHotel) {
        Hotel hotel = servicio.getHotel(idHotel);
        if (hotel == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(hotel.getFotos());
    }

    @GetMapping("/{idHotel}/habitaciones")
    public ResponseEntity<List<Habitacion>> getHabitacionesHotel(@PathVariable Integer idHotel) {
        Hotel hotel = servicio.getHotel(idHotel);
        if (hotel == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(hotel.getHabitaciones());
    }

    @GetMapping("/{idHotel}/valoraciones")
    public ResponseEntity<List<Valoracion>> getValoracionesHotel(@PathVariable Integer idHotel) {
        Hotel hotel = servicio.getHotel(idHotel);
        if (hotel == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(hotel.getValoraciones());
    }
}