package com.example.horasunab.model.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(
        primaryKeys = {"uid","eid"},
        foreignKeys = {
            @ForeignKey(
                    entity = Usuario.class,
                    parentColumns = "uid",
                    childColumns = "uid",
                    onDelete = ForeignKey.CASCADE),

                @ForeignKey(
                        entity = Evento.class,
                        parentColumns = "eid",
                        childColumns = "eid"
                )
        }
)
public class UsuarioEvento {
    @NonNull
    public String uid;

    @NonNull
    public int eid;

    public UsuarioEvento(@NonNull String uid, @NonNull int eid) {
        this.uid = uid;
        this.eid = eid;
    }

}
