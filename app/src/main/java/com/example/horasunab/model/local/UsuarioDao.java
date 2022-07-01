package com.example.horasunab.model.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.horasunab.model.entity.Usuario;

import java.util.List;

@Dao
public interface UsuarioDao {

    @Query("select * from Usuario")
    List<Usuario> getAll();

    @Query("SELECT * FROM Usuario WHERE uid=(:uid) and password=(:password)")
    Usuario login(String uid, String password);

    @Insert
    void crearUsuario(Usuario miUsuario);

}
