package com.hotels17.backendproyecto.controlador;

import com.hotels17.backendproyecto.dto.NuevaReservaDTO;
import com.hotels17.backendproyecto.dto.ReservaDTO;
import com.hotels17.backendproyecto.modelo.Reserva;
import com.hotels17.backendproyecto.servicio.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/reservas")
@CrossOrigin("http://localhost:4200")
public class ReservasControlador {

    @Autowired
    private Servicio servicio;

    @GetMapping()
    public List<ReservaDTO> getReservas() {
        return servicio.getReservas();
    }
    @PostMapping()
    public ResponseEntity<ReservaDTO> nuevaReserva(@RequestBody NuevaReservaDTO nuevaReserva) {
        Reserva reserva = servicio.nuevaReserva(nuevaReserva);
        ReservaDTO reservaDTO = servicio.getReserva(reserva.getId());
        try {
            return ResponseEntity.created(new URI("/" + reserva.getId())).body(reservaDTO);
        } catch (URISyntaxException e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }
}