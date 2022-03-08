package com.hotels17.backendproyecto.dto;

import java.util.Date;
import java.util.Objects;

public class ReservaDTO {

    private Integer id;
    private Integer idHabitacion;
    private UsuarioDTO usuario;
    private Integer numeroHuespedes;
    private Date fechaEntrada;
    private Date fechaSalida;
    private Double precioTotal;
    private Boolean desayuno;

    public ReservaDTO() {
    }

    public ReservaDTO(Integer idHabitacion, UsuarioDTO usuario, Integer numeroHuespedes, Date fechaEntrada,
                      Date fechaSalida, Double precioTotal, Boolean desayuno) {
        this.idHabitacion = idHabitacion;
        this.usuario = usuario;
        this.numeroHuespedes = numeroHuespedes;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.precioTotal = precioTotal;
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

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
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

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
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
        if (!(o instanceof ReservaDTO)) return false;
        ReservaDTO that = (ReservaDTO) o;
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
                ", usuario=" + usuario +
                ", numeroHuespedes=" + numeroHuespedes +
                ", fechaEntrada=" + fechaEntrada +
                ", fechaSalida=" + fechaSalida +
                ", precioTotal=" + precioTotal +
                ", desayuno=" + desayuno +
                '}';
    }
}