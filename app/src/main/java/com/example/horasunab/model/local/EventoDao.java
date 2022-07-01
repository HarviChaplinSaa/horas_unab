package com.example.horasunab.model.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.horasunab.model.entity.Evento;

import java.util.List;

@Dao
public interface EventoDao {

    @Query("select * from Evento")
    List<Evento> getEventos();

    @Insert
    void crearevento(Evento miEvento);

    @Update
    void actualizarEvento(Evento miEvento);

    @Delete
    void eliminarEvento(Evento miEvento);

}
