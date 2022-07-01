package com.example.horasunab.model.repository;

import android.content.Context;

import com.example.horasunab.model.entity.Evento;
import com.example.horasunab.model.local.AppDataBase;
import com.example.horasunab.model.local.EventoDao;

import java.util.List;

public class EventoRepository {
    private EventoDao eventoDao;

    public EventoRepository(Context miContexto) {
        AppDataBase db = AppDataBase.obtenerInstancia(miContexto);
        eventoDao = db.eventoDao();
    }

    public List<Evento> obtenerEventos(){return eventoDao.getEventos();}

    public void agregarEvento(Evento miEvento){
        eventoDao.crearevento(miEvento);
    }

    public void actualizarEvento(Evento miEvento){
        eventoDao.actualizarEvento(miEvento);
    }

    public void eliminarEvento(Evento miEvento){
        eventoDao.eliminarEvento(miEvento);
    }
}
