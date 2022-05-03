package com.hotels17.backendproyecto.controlador;

import com.hotels17.backendproyecto.dto.ReservaDTO;
import com.hotels17.backendproyecto.dto.UsuarioDTO;
import com.hotels17.backendproyecto.dto.ValoracionDTO;
import com.hotels17.backendproyecto.modelo.Usuario;
import com.hotels17.backendproyecto.servicio.Servicio;
import com.hotels17.backendproyecto.util.Encriptacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("http://localhost:4200")
public class UsuariosControlador {

    @Autowired
    private Servicio servicio;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuario(@PathVariable Integer id) {
        Usuario usuario = servicio.getUsuario(id);

        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        UsuarioDTO usuarioDetalles = servicio.getUsuarioDto(usuario);
        return ResponseEntity.ok(usuarioDetalles);
    }

    @PostMapping("/registro")
    public ResponseEntity<UsuarioDTO> registrarUsuario(@RequestBody Usuario usuario) {
        String salt = Encriptacion.generarSalt();
        String password = usuario.getPassword();
        String passwordEncriptada = Encriptacion.hashPassword(password, salt);

        usuario.setSalt(salt);
        usuario.setPassword(passwordEncriptada);
        usuario = servicio.registrarUsuario(usuario);

        if (usuario == null) { // Ya existe un usuario con ese email
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        UsuarioDTO usuarioDTO = servicio.getUsuarioDto(usuario);

        try {
            return ResponseEntity.created(new URI("/" + usuario.getId())).body(usuarioDTO);
        } catch (URISyntaxException e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioDTO> login(@RequestBody Usuario credencialesUsuario) {
        Usuario usuario = servicio.login(credencialesUsuario.getEmail(), credencialesUsuario.getPassword());
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        UsuarioDTO usuarioDetalles = servicio.getUsuarioDto(usuario);
        return ResponseEntity.ok(usuarioDetalles);
    }

    @GetMapping("/{idUsuario}/reservas")
    public ResponseEntity<List<ReservaDTO>> getReservasUsuario(@PathVariable Integer idUsuario) {
        Usuario usuario = servicio.getUsuario(idUsuario);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(servicio.getReservasUsuario(usuario));
    }

    @GetMapping("/usuarios/{idUsuario}/valoraciones")
    public ResponseEntity<List<ValoracionDTO>> getValoracionesUsuario(@PathVariable Integer idUsuario) {
        Usuario usuario = servicio.getUsuario(idUsuario);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(servicio.getValoracionesUsuario(usuario));
    }
}