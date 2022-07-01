package com.example.horasunab.model.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Evento implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int eid;

    @NonNull
    private String nombreEvento;

    @NonNull
    private Integer cantidadHoras;

    @NonNull
    private String urlImagen;

    @NonNull
    private Integer horaEvento;
    //private Time horaEvento;

    @NonNull
    private String fechaEvento;
    //private Date fechaEvento;

    @NonNull
    private String lugarEvento;

    private String descripcionEvento;

    public Evento(@NonNull String nombreEvento, @NonNull Integer cantidadHoras, @NonNull String urlImagen, @NonNull Integer horaEvento, @NonNull String fechaEvento, @NonNull String lugarEvento, String descripcionEvento) {
        this.nombreEvento = nombreEvento;
        this.cantidadHoras = cantidadHoras;
        this.urlImagen = urlImagen;
        this.horaEvento = horaEvento;
        this.fechaEvento = fechaEvento;
        this.lugarEvento = lugarEvento;
        this.descripcionEvento = descripcionEvento;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    @NonNull
    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(@NonNull String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    @NonNull
    public Integer getCantidadHoras() {
        return cantidadHoras;
    }

    public void setCantidadHoras(@NonNull Integer cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
    }

    @NonNull
    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(@NonNull String urlImagen) {
        this.urlImagen = urlImagen;
    }

    @NonNull
    public Integer getHoraEvento() {
        return horaEvento;
    }

    public void setHoraEvento(@NonNull Integer horaEvento) {
        this.horaEvento = horaEvento;
    }

    @NonNull
    public String getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(@NonNull String fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    @NonNull
    public String getLugarEvento() {
        return lugarEvento;
    }

    public void setLugarEvento(@NonNull String lugarEvento) {
        this.lugarEvento = lugarEvento;
    }

    public String getDescripcionEvento() {
        return descripcionEvento;
    }

    public void setDescripcionEvento(String descripcionEvento) {
        this.descripcionEvento = descripcionEvento;
    }
}
