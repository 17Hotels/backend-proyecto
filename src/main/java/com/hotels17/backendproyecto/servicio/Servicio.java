package com.hotels17.backendproyecto.servicio;

import com.hotels17.backendproyecto.dto.ReservaDTO;
import com.hotels17.backendproyecto.dto.UsuarioDTO;
import com.hotels17.backendproyecto.modelo.*;
import com.hotels17.backendproyecto.repositorio.*;
import com.hotels17.backendproyecto.util.Encriptacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Servicio {

    @Autowired
    private UsuariosRepositorio daoUsuarios;
    @Autowired
    private HotelesRepositorio daoHoteles;
    @Autowired
    private HabitacionesRepositorio daoHabitaciones;
    @Autowired
    private ValoracionesRepositorio daoValoraciones;
    @Autowired
    private ReservasRepositorio daoReservas;
    @Autowired
    private FotosRepositorio daoFotos;

    public Usuario getUsuario(Integer id) {
        return daoUsuarios.findById(id).orElse(null);
    }

    public Usuario registrarUsuario(Usuario usuario) {
        return daoUsuarios.save(usuario);
    }

    public Usuario login(String email, String password) {
        Usuario usuarioByEmail = daoUsuarios.findUsuarioByEmail(email).orElse(null);
        if (usuarioByEmail == null) {
            return null;
        }
        String salt = usuarioByEmail.getSalt();
        String passwordEncriptada = Encriptacion.hashPassword(password, salt);

        if (passwordEncriptada.equals(usuarioByEmail.getPassword())) {
            return usuarioByEmail;
        } else {
            return null;
        }
    }

    public UsuarioDTO getUsuarioDto(Usuario usuario) {
        UsuarioDTO usuarioDetalles = new UsuarioDTO();
        usuarioDetalles.setId(usuario.getId());
        usuarioDetalles.setNombre(usuario.getNombre());
        usuarioDetalles.setApellidos(usuario.getApellidos());
        usuarioDetalles.setEmail(usuario.getEmail());
        return usuarioDetalles;
    }

    public Hotel getHotel(Integer id) {
        return daoHoteles.findById(id).orElse(null);
    }

    public Hotel getHotel(String nombre) {
        return daoHoteles.findByNombre(nombre).orElse(null);
    }

    public List<Hotel> getHoteles() {
        return daoHoteles.findAll();
    }

    public List<Hotel> getHotelesPorPais(String pais) {
        return daoHoteles.findAllByPais(pais, Sort.by(Sort.Direction.ASC, "nombre"));
    }

    public List<Hotel> getHotelesPorCiudad(String ciudad) {
        return daoHoteles.findAllByCiudad(ciudad, Sort.by(Sort.Direction.ASC, "nombre"));
    }

    public Habitacion getHabitacion(Integer idHabitacion) {
        return daoHabitaciones.findById(idHabitacion).orElse(null);
    }

    public Valoracion getValoracion(Integer idValoracion) {
        return daoValoraciones.findById(idValoracion).orElse(null);
    }

    public Reserva getReserva(Integer idReserva) {
        return daoReservas.findById(idReserva).orElse(null);
    }

    public ReservaDTO getReservaDto(Reserva reserva) {
        ReservaDTO reservaDetalles = new ReservaDTO();
        reservaDetalles.setDesayuno(reserva.getDesayuno());
        reservaDetalles.setFechaEntrada(reserva.getFechaEntrada());
        reservaDetalles.setFechaSalida(reserva.getFechaSalida());
        reservaDetalles.setId(reserva.getId());
        reservaDetalles.setIdHabitacion(reserva.getHabitacion().getId());
        reservaDetalles.setIdUsuario(reserva.getUsuario().getId());
        reservaDetalles.setNumeroHuespedes(reserva.getNumeroHuespedes());
        reservaDetalles.setPrecioTotal(reserva.getPrecioTotal());
        return reservaDetalles;
    }

    public List<ReservaDTO> getReservasDtoUsuario(Usuario usuario) {
        List<ReservaDTO> reservasDto = new ArrayList<>();
        for (Reserva r : usuario.getReservas()) {
            reservasDto.add(getReservaDto(r));
        }
        return reservasDto;
    }

    public Reserva nuevaReserva(ReservaDTO nuevaReserva) {
        Reserva reserva = new Reserva();
        reserva.setDesayuno(nuevaReserva.getDesayuno());
        reserva.setFechaEntrada(nuevaReserva.getFechaEntrada());
        reserva.setFechaSalida(nuevaReserva.getFechaSalida());
        reserva.setId(nuevaReserva.getId());
        reserva.setHabitacion(getHabitacion(nuevaReserva.getIdHabitacion()));
        reserva.setUsuario(getUsuario(nuevaReserva.getIdUsuario()));
        reserva.setNumeroHuespedes(nuevaReserva.getNumeroHuespedes());
        reserva.setPrecioTotal(nuevaReserva.getPrecioTotal());
        return daoReservas.save(reserva);
    }

    public Reserva modificarReserva(Reserva reserva) {
        return daoReservas.save(reserva);
    }

    public void eliminarReserva(Integer idReserva) {
        daoReservas.deleteById(idReserva);
    }
}