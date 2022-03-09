package com.hotels17.backendproyecto.dto;

import java.util.Objects;

public class HabitacionDTO {

    private Integer id;
    private String nombre;
    private Integer idHotel;
    private Double precioNoche;
    private Double precioDesayuno;
    private Integer capacidad;

    public HabitacionDTO() {
    }

    public HabitacionDTO(String nombre, Integer idHotel, Double precioNoche, Double precioDesayuno,
                         Integer capacidad) {
        this.nombre = nombre;
        this.idHotel = idHotel;
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

    public Integer getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Integer idHotel) {
        this.idHotel = idHotel;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HabitacionDTO)) return false;
        HabitacionDTO that = (HabitacionDTO) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "HabitacionDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", idHotel=" + idHotel +
                ", precioNoche=" + precioNoche +
                ", precioDesayuno=" + precioDesayuno +
                ", capacidad=" + capacidad +
                '}';
    }
}