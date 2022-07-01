package com.example.horasunab.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Usuario implements Serializable {

    @PrimaryKey
    @NonNull
    private String uid;

    @ColumnInfo(name = "nombreUsuario")
    @NonNull
    private String nombre;

    @ColumnInfo(name = "apellidoUsuario")
    @NonNull
    private String apellido;

    @NonNull
    private String password;

    @NonNull
    private String carrera;

    @NonNull
    private String email;

    @NonNull
    private boolean tipoUsuario;


    public Usuario(@NonNull String uid, @NonNull String nombre, @NonNull String apellido, @NonNull String password, @NonNull String carrera, @NonNull String email, boolean tipoUsuario) {
        this.uid = uid;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.carrera = carrera;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
    }

    public boolean isNull(/*String uid, String nombre, String apellido, String password, String carrera, String email*/){
        if (uid.equals("")||nombre.equals("")||apellido.equals("")||password.equals("")|| carrera.equals("")||email.equals("")){
            return  true;
        }else{
            return false;
        }
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(boolean tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
