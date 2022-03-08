package com.hotels17.backendproyecto.repositorio;

import com.hotels17.backendproyecto.modelo.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitacionesRepositorio extends JpaRepository<Habitacion, Integer> {
}
