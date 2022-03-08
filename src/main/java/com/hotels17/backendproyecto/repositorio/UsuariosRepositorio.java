package com.hotels17.backendproyecto.repositorio;

import com.hotels17.backendproyecto.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuariosRepositorio extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findUsuarioByEmail(String email);
}