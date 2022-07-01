package com.example.horasunab.model.repository;

import android.content.Context;

import com.example.horasunab.model.entity.Usuario;
import com.example.horasunab.model.local.AppDataBase;
import com.example.horasunab.model.local.UsuarioDao;

import java.util.List;

public class UsuarioRepository {
    private UsuarioDao usuarioDao;

    public UsuarioRepository(Context miContexto){
        AppDataBase db = AppDataBase.obtenerInstancia(miContexto);
        usuarioDao = db.usuarioDao();
    }

    public List<Usuario> obtenerUsuarios(){ return usuarioDao.getAll(); }

    public Usuario login(String user, String password){ return usuarioDao.login(user, password); }

    public void agregarUsuario(Usuario miUsuario){ usuarioDao.crearUsuario(miUsuario); }

}
