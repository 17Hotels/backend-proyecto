package com.hotels17.backendproyecto.controlador;

import com.hotels17.backendproyecto.dto.HabitacionDTO;
import com.hotels17.backendproyecto.servicio.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/habitaciones")
@CrossOrigin("http://localhost:4200")
public class HabitacionesControlador {

    @Autowired
    private Servicio servicio;

    @GetMapping("/{idHabitacion}")
    public ResponseEntity<HabitacionDTO> getHabitacion(@PathVariable Integer idHabitacion) {
        HabitacionDTO habitacion = servicio.getHabitacionDTO(idHabitacion);

        if (habitacion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(habitacion);
    }
}
