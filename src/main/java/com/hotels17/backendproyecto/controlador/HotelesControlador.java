package com.hotels17.backendproyecto.controlador;

import com.hotels17.backendproyecto.modelo.*;
import com.hotels17.backendproyecto.servicio.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hoteles")
public class HotelesControlador {

    @Autowired
    private Servicio servicio;

    @GetMapping("/hoteles")
    public List<Hotel> getHoteles() {
        return servicio.getHoteles();
    }

    @GetMapping("/hoteles/pais/{pais}")
    public List<Hotel> getHotelesPorPais(@PathVariable String pais) {
        return servicio.getHotelesPorPais(pais);
    }

    @GetMapping("/hoteles/ciudad/{ciudad}")
    public List<Hotel> getHotelesPorCiudad(@PathVariable String ciudad) {
        return servicio.getHotelesPorCiudad(ciudad);
    }

    @GetMapping("/hoteles/{idHotel}")
    public ResponseEntity<Hotel> getHotel(@PathVariable Integer idHotel) {
        Hotel hotel = servicio.getHotel(idHotel);

        if (hotel == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(hotel);
    }

    @GetMapping("/hoteles/{idHotel}/fotos")
    public ResponseEntity<List<Foto>> getFotosHotel(@PathVariable Integer idHotel) {
        Hotel hotel = servicio.getHotel(idHotel);
        if (hotel == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(hotel.getFotos());
    }

    @GetMapping("/hoteles/{idHotel}/habitaciones")
    public ResponseEntity<List<Habitacion>> getHabitacionesHotel(@PathVariable Integer idHotel) {
        Hotel hotel = servicio.getHotel(idHotel);
        if (hotel == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(hotel.getHabitaciones());
    }

    @GetMapping("/hoteles/{idHotel}/valoraciones")
    public ResponseEntity<List<Valoracion>> getValoracionesHotel(@PathVariable Integer idHotel) {
        Hotel hotel = servicio.getHotel(idHotel);
        if (hotel == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(hotel.getValoraciones());
    }
}