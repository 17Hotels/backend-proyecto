package com.hotels17.backendproyecto.repositorio;

import com.hotels17.backendproyecto.modelo.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservasRepositorio extends JpaRepository<Reserva, Integer> {
}