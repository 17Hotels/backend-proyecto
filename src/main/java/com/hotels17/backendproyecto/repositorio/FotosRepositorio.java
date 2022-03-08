package com.hotels17.backendproyecto.repositorio;

import com.hotels17.backendproyecto.modelo.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotosRepositorio extends JpaRepository<Foto, Integer> {
}
