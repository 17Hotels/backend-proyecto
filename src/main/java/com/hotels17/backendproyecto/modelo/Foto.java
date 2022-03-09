package com.hotels17.backendproyecto.modelo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Fotos")
public class Foto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_hotel")
    private Hotel hotel;
    private String enlace;

    public Foto() {
    }

    public Foto(Integer id, Hotel hotel, String enlace) {
        this.id = id;
        this.hotel = hotel;
        this.enlace = enlace;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Foto)) return false;
        Foto foto = (Foto) o;
        return id.equals(foto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Foto{" +
                "id=" + id +
                ", hotel=" + hotel +
                ", enlace='" + enlace + '\'' +
                '}';
    }
}