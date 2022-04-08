package com.hotels17.backendproyecto.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Hoteles")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String pais;
    private String codigoPostal;
    private String email;
    private String telefono;
    private String web;
    @Column(name = "numero_estrellas")
    private Integer estrellas;
    private String descripcion;
    private Boolean wifi;
    @Column(name = "aire_acondicionado")
    private Boolean aireAcondicionado;
    private Boolean parking;
    private Boolean mascotas;
    private Boolean gimnasio;
    private Boolean calefaccion;
    private Boolean accesibilidad;
    @Column(name = "hora_entrada")
    private String horaEntrada;
    @Column(name = "hora_salida")
    private String horaSalida;
    @Column(name = "precio_parking")
    private Double precioParking;
    @OneToMany(mappedBy = "hotel")
    private List<Foto> fotos;
    @OneToMany(mappedBy = "hotel")
    @JsonIgnore
    private List<Habitacion> habitaciones;
    @OneToMany(mappedBy = "hotel")
    @JsonIgnore
    private List<Valoracion> valoraciones;

    public Hotel() {
    }

    public Hotel(String nombre, String direccion, String ciudad, String pais, String codigoPostal,
                 String email, String telefono, String web, Integer estrellas, String descripcion,
                 Boolean wifi, Boolean aireAcondicionado, Boolean parking, Boolean mascotas, Boolean gimnasio,
                 Boolean calefaccion, Boolean accesibilidad, String horaEntrada, String horaSalida,
                 Double precioParking) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.pais = pais;
        this.codigoPostal = codigoPostal;
        this.email = email;
        this.telefono = telefono;
        this.web = web;
        this.estrellas = estrellas;
        this.descripcion = descripcion;
        this.wifi = wifi;
        this.aireAcondicionado = aireAcondicionado;
        this.parking = parking;
        this.mascotas = mascotas;
        this.gimnasio = gimnasio;
        this.calefaccion = calefaccion;
        this.accesibilidad = accesibilidad;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.precioParking = precioParking;
    }

    public Double getPrecioMinimoHabitacion(){
        return getHabitaciones().stream().mapToDouble(Habitacion::getPrecioNoche).min().orElse(0);
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public Integer getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(Integer estrellas) {
        this.estrellas = estrellas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean getAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(Boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public Boolean getParking() {
        return parking;
    }

    public void setParking(Boolean parking) {
        this.parking = parking;
    }

    public Boolean getMascotas() {
        return mascotas;
    }

    public void setMascotas(Boolean mascotas) {
        this.mascotas = mascotas;
    }

    public Boolean getGimnasio() {
        return gimnasio;
    }

    public void setGimnasio(Boolean gimnasio) {
        this.gimnasio = gimnasio;
    }

    public Boolean getCalefaccion() {
        return calefaccion;
    }

    public void setCalefaccion(Boolean calefaccion) {
        this.calefaccion = calefaccion;
    }

    public Boolean getAccesibilidad() {
        return accesibilidad;
    }

    public void setAccesibilidad(Boolean accesibilidad) {
        this.accesibilidad = accesibilidad;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Double getPrecioParking() {
        return precioParking;
    }

    public void setPrecioParking(Double precioParking) {
        this.precioParking = precioParking;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public List<Valoracion> getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(List<Valoracion> valoraciones) {
        this.valoraciones = valoraciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return id.equals(hotel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", pais='" + pais + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", web='" + web + '\'' +
                ", estrellas=" + estrellas +
                ", descripcion='" + descripcion + '\'' +
                ", wifi=" + wifi +
                ", aireAcondicionado=" + aireAcondicionado +
                ", parking=" + parking +
                ", mascotas=" + mascotas +
                ", gimnasio=" + gimnasio +
                ", calefaccion=" + calefaccion +
                ", accesibilidad=" + accesibilidad +
                ", horaEntrada='" + horaEntrada + '\'' +
                ", horaSalida='" + horaSalida + '\'' +
                ", precioParking=" + precioParking +
                '}';
    }
}