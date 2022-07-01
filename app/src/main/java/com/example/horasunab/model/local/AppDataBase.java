package com.example.horasunab.model.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.horasunab.model.entity.Evento;
import com.example.horasunab.model.entity.Usuario;
import com.example.horasunab.model.entity.UsuarioEvento;

@Database(entities = {
        Usuario.class,
        Evento.class
        //UsuarioEvento.class,
        //UsuarioEventoCrossRef.class,
        //UsuarioWithEvento.class
        }, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract UsuarioDao usuarioDao();
    public abstract EventoDao eventoDao();

    private static AppDataBase instancia = null;

    public static AppDataBase obtenerInstancia(Context micontexto){
        if (instancia == null){
            instancia = Room.databaseBuilder(micontexto, AppDataBase.class, "HorasLibres-DataBase")
                    .allowMainThreadQueries().build();
        }
        return instancia;
    }
}
