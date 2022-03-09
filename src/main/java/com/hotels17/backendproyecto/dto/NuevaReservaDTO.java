package com.hotels17.backendproyecto.dto;

import java.util.Date;
import java.util.Objects;

public class NuevaReservaDTO {

    private Integer id;
    private Integer idHabitacion;
    private Integer idUsuario;
    private Integer numeroHuespedes;
    private Date fechaEntrada;
    private Date fechaSalida;
    private Boolean desayuno;

    public NuevaReservaDTO() {
    }

    public NuevaReservaDTO(Integer idHabitacion, Integer idUsuario, Integer numeroHuespedes, Date fechaEntrada,
                           Date fechaSalida, Boolean desayuno) {
        this.idHabitacion = idHabitacion;
        this.idUsuario = idUsuario;
        this.numeroHuespedes = numeroHuespedes;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.desayuno = desayuno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Integer idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getNumeroHuespedes() {
        return numeroHuespedes;
    }

    public void setNumeroHuespedes(Integer numeroHuespedes) {
        this.numeroHuespedes = numeroHuespedes;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Boolean getDesayuno() {
        return desayuno;
    }

    public void setDesayuno(Boolean desayuno) {
        this.desayuno = desayuno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NuevaReservaDTO)) return false;
        NuevaReservaDTO that = (NuevaReservaDTO) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ReservaDTO{" +
                "id=" + id +
                ", idHabitacion=" + idHabitacion +
                ", idUsuario=" + idUsuario +
                ", numeroHuespedes=" + numeroHuespedes +
                ", fechaEntrada=" + fechaEntrada +
                ", fechaSalida=" + fechaSalida +
                ", desayuno=" + desayuno +
                '}';
    }
}
