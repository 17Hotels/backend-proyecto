package com.hotels17.backendproyecto.servicio;

import com.hotels17.backendproyecto.dto.*;
import com.hotels17.backendproyecto.modelo.*;
import com.hotels17.backendproyecto.repositorio.*;
import com.hotels17.backendproyecto.util.Encriptacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
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

    /*
     *   Métodos del usuario
     */
    public Usuario getUsuario(Integer id) {
        return daoUsuarios.findById(id).orElse(null);
    }

    public Usuario registrarUsuario(Usuario usuario) {
        Usuario buscarUsuario = daoUsuarios.findUsuarioByEmail(usuario.getEmail()).orElse(null);
        if (buscarUsuario != null) {
            return null;
        }
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

    public List<ReservaDTO> getReservasUsuario(Usuario usuario) {
        List<ReservaDTO> reservasDto = new ArrayList<>();
        for (Reserva r : usuario.getReservas()) {
            reservasDto.add(getReservaDto(r));
        }
        return reservasDto;
    }

    public UsuarioDTO getUsuarioDto(Usuario usuario) {
        UsuarioDTO usuarioDetalles = new UsuarioDTO();
        usuarioDetalles.setId(usuario.getId());
        usuarioDetalles.setNombre(usuario.getNombre());
        usuarioDetalles.setApellidos(usuario.getApellidos());
        usuarioDetalles.setEmail(usuario.getEmail());
        return usuarioDetalles;
    }

    public List<ValoracionDTO> getValoracionesUsuario(Usuario usuario) {
        List<ValoracionDTO> valoracionesDto = new ArrayList<>();
        for (Valoracion v : usuario.getValoraciones()) {
            valoracionesDto.add(getValoracionDto(v));
        }
        return valoracionesDto;
    }

    /*
     *   Métodos del hotel
     */

    public Hotel getHotel(Integer id) {
        return daoHoteles.findById(id).orElse(null);
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

    public List<ReservaDTO> getReservasHotel(Hotel hotel) {
        List<ReservaDTO> reservasDto = new ArrayList<>();
        for (Habitacion h : hotel.getHabitaciones()) {
            for (Reserva r : h.getReservas()) {
                reservasDto.add(getReservaDto(r));
            }
        }
        return reservasDto;
    }

    public List<ValoracionDTO> getValoracionesHotel(Hotel hotel) {
        List<ValoracionDTO> valoracionesDto = new ArrayList<>();
        for (Valoracion v : hotel.getValoraciones()) {
            valoracionesDto.add(getValoracionDto(v));
        }
        return valoracionesDto;
    }

    /*
     *   Métodos de la habitación
     */

    public Habitacion getHabitacion(Integer idHabitacion) {
        return daoHabitaciones.findById(idHabitacion).orElse(null);
    }

    public HabitacionDTO getHabitacionDTO(Integer idHabitacion) {
        Habitacion habitacion = daoHabitaciones.findById(idHabitacion).orElse(null);
        if (habitacion == null) {
            return null;
        }
        return getHabitacionDto(habitacion);
    }

    private HabitacionDTO getHabitacionDto(Habitacion habitacion) {
        HabitacionDTO habitacionDto = new HabitacionDTO();
        habitacionDto.setCapacidad(habitacion.getCapacidad());
        habitacionDto.setId(habitacion.getId());
        habitacionDto.setIdHotel(habitacion.getHotel().getId());
        habitacionDto.setNombre(habitacion.getNombre());
        habitacionDto.setPrecioDesayuno(habitacion.getPrecioDesayuno());
        habitacionDto.setPrecioNoche(habitacion.getPrecioNoche());
        return habitacionDto;
    }

    public List<HabitacionDTO> getHabitacionesHotel(Hotel hotel) {
        List<HabitacionDTO> habitacionesDto = new ArrayList<>();
        for (Habitacion h : hotel.getHabitaciones()) {
            habitacionesDto.add(getHabitacionDto(h));
        }
        return habitacionesDto;
    }

    /*
     *   Métodos de la reserva
     */

    public ReservaDTO getReserva(Integer idReserva) {
        Reserva reserva = daoReservas.findById(idReserva).orElse(null);
        if (reserva == null) {
            return null;
        }
        return getReservaDto(reserva);
    }

    private ReservaDTO getReservaDto(Reserva reserva) {
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

    public List<ReservaDTO> getReservas() {
        List<ReservaDTO> reservasDto = new ArrayList<>();
        for (Reserva r : daoReservas.findAll()) {
            reservasDto.add(getReservaDto(r));
        }
        return reservasDto;
    }

    public Reserva nuevaReserva(NuevaReservaDTO nuevaReserva) {
        Reserva reserva = new Reserva();
        reserva.setDesayuno(nuevaReserva.getDesayuno());
        reserva.setFechaEntrada(nuevaReserva.getFechaEntrada());
        reserva.setFechaSalida(nuevaReserva.getFechaSalida());
        reserva.setId(nuevaReserva.getId());
        reserva.setHabitacion(getHabitacion(nuevaReserva.getIdHabitacion()));
        reserva.setUsuario(getUsuario(nuevaReserva.getIdUsuario()));
        reserva.setNumeroHuespedes(nuevaReserva.getNumeroHuespedes());
        reserva.setPrecioTotal(reserva.calcularPrecioTotal());
        return daoReservas.save(reserva);
    }

    /*
     *   Métodos de la valoración
     */

    private ValoracionDTO getValoracionDto(Valoracion valoracion) {
        ValoracionDTO valoracionDto = new ValoracionDTO();
        valoracionDto.setComentario(valoracion.getComentario());
        valoracionDto.setFecha(valoracion.getFecha());
        valoracionDto.setId(valoracion.getId());
        valoracionDto.setIdHotel(valoracion.getHotel().getId());
        valoracionDto.setIdUsuario(valoracion.getUsuario().getId());
        valoracionDto.setNota(valoracion.getNota());
        return valoracionDto;
    }

    public ValoracionDTO valorarHotel(ValoracionDTO valoracionDTO) {
        Valoracion valoracion = new Valoracion(
                getUsuario(valoracionDTO.getIdUsuario()),
                getHotel(valoracionDTO.getIdHotel()),
                valoracionDTO.getComentario(),
                valoracionDTO.getFecha(),
                valoracionDTO.getNota()
        );
        valoracion = daoValoraciones.save(valoracion);
        return getValoracionDto(valoracion);
    }
}