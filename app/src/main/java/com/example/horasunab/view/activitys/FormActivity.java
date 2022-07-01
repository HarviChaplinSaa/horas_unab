package com.example.horasunab.view.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.horasunab.R;
import com.example.horasunab.model.entity.Evento;
import com.example.horasunab.model.repository.EventoRepository;
import com.google.android.material.textfield.TextInputLayout;

public class FormActivity extends AppCompatActivity {

    private TextView tvTitulo;
    private TextInputLayout etNombre, etFecha, etHora, etDes, etLugar, etCantidadHora, etUrl;
    private Button btAgregar;
    private Evento miEvento;
    private EventoRepository eventoRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        tvTitulo = findViewById(R.id.tv_form_title);
        etNombre = (TextInputLayout) findViewById(R.id.et_form_name_event);
        etFecha = (TextInputLayout) findViewById(R.id.et_form_date_event);
        etHora = (TextInputLayout) findViewById(R.id.et_form_hour_event);
        etDes = (TextInputLayout) findViewById(R.id.et_form_desc_event);
        etLugar = (TextInputLayout) findViewById(R.id.et_form_link_event);
        etCantidadHora = (TextInputLayout) findViewById(R.id.et_form_amout_event);
        etUrl =(TextInputLayout) findViewById(R.id.tv_form_urlimagen);
        btAgregar = findViewById(R.id.bt_add_form);


        eventoRepository = new EventoRepository(FormActivity.this);

        miEvento = (Evento) getIntent().getSerializableExtra("evento");


        if (miEvento!=null){
             tvTitulo.setText("Editar Evento");
             btAgregar.setText("Editar");
            etNombre.getEditText().setText(miEvento.getNombreEvento());
            etFecha.getEditText().setText(miEvento.getFechaEvento());
            etHora.getEditText().setText(String.valueOf(miEvento.getHoraEvento()));
            etDes.getEditText().setText(miEvento.getDescripcionEvento());
            etLugar.getEditText().setText(miEvento.getLugarEvento());
            etCantidadHora.getEditText().setText(String.valueOf(miEvento.getCantidadHoras()));
            etUrl.getEditText().setText(miEvento.getUrlImagen());



            btAgregar.setOnClickListener(view -> {
                miEvento.setNombreEvento(etNombre.getEditText().getText().toString());
                miEvento.setCantidadHoras(Integer.parseInt(etCantidadHora.getEditText().getText().toString()));
                miEvento.setUrlImagen(etUrl.getEditText().getText().toString());
                miEvento.setHoraEvento(Integer.parseInt(etHora.getEditText().getText().toString()));
                miEvento.setFechaEvento(etFecha.getEditText().getText().toString());
                miEvento.setLugarEvento(etLugar.getEditText().getText().toString());
                miEvento.setDescripcionEvento(etDes.getEditText().getText().toString());

                eventoRepository.actualizarEvento(miEvento);
                Intent i = new Intent();
                i.putExtra("eventoDetalle", miEvento);
                setResult(RESULT_OK, i);
                finish();
            });
        }else{


            btAgregar.setOnClickListener(view -> {

                miEvento = new Evento(
                        etNombre.getEditText().getText().toString(),
                        Integer.parseInt(etCantidadHora.getEditText().getText().toString()),
                        etUrl.getEditText().getText().toString(),
                        Integer.parseInt(etHora.getEditText().getText().toString()),
                        etFecha.getEditText().getText().toString(),
                        etLugar.getEditText().getText().toString(),
                        etDes.getEditText().getText().toString()
                );


                eventoRepository.agregarEvento(miEvento);
                setResult(RESULT_OK);
                finish();
            });
        }


    }
}