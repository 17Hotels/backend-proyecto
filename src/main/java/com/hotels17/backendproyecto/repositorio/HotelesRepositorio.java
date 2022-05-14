package com.hotels17.backendproyecto.repositorio;

import com.hotels17.backendproyecto.modelo.Hotel;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelesRepositorio extends JpaRepository<Hotel, Integer> {

    List<Hotel> findAllByPais(String pais, Sort sort);

    List<Hotel> findAllByCiudad(String ciudad, Sort sort);
}