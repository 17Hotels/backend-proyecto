package com.hotels17.backendproyecto.repositorio;

import com.hotels17.backendproyecto.modelo.Valoracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValoracionesRepositorio extends JpaRepository<Valoracion, Integer> {
}