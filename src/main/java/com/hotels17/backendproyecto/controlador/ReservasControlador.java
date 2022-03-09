package com.hotels17.backendproyecto.controlador;

import com.hotels17.backendproyecto.dto.NuevaReservaDTO;
import com.hotels17.backendproyecto.dto.ReservaDTO;
import com.hotels17.backendproyecto.modelo.Reserva;
import com.hotels17.backendproyecto.servicio.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/reservas")
public class ReservasControlador {

    @Autowired
    private Servicio servicio;

    @PostMapping()
    public ResponseEntity<NuevaReservaDTO> nuevaReserva(@RequestBody NuevaReservaDTO nuevaReserva) {
        Reserva reserva = servicio.nuevaReserva(nuevaReserva);
        try {
            return ResponseEntity.created(new URI("/" + reserva.getId())).build();
        } catch (URISyntaxException e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }
}