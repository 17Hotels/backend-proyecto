package com.hotels17.backendproyecto.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Habitaciones")
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "id_hotel")
    @JsonIgnore
    private Hotel hotel;
    @Column(name = "precio_noche")
    private Double precioNoche;
    @Column(name = "precio_desayuno")
    private Double precioDesayuno;
    private Integer capacidad;
    @OneToMany(mappedBy = "habitacion")
    private List<Reserva> reservas;

    public Habitacion() {
    }

    public Habitacion(String nombre, Hotel hotel, Double precioNoche, Double precioDesayuno, Integer capacidad) {
        this.nombre = nombre;
        this.hotel = hotel;
        this.precioNoche = precioNoche;
        this.precioDesayuno = precioDesayuno;
        this.capacidad = capacidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(Double precioNoche) {
        this.precioNoche = precioNoche;
    }

    public Double getPrecioDesayuno() {
        return precioDesayuno;
    }

    public void setPrecioDesayuno(Double precioDesayuno) {
        this.precioDesayuno = precioDesayuno;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Habitacion)) return false;
        Habitacion that = (Habitacion) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", hotel=" + hotel +
                ", precioNoche=" + precioNoche +
                ", precioDesayuno=" + precioDesayuno +
                ", capacidad=" + capacidad +
                '}';
    }
}