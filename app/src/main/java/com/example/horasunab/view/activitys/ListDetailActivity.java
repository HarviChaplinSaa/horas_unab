package com.example.horasunab.view.activitys;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.horasunab.R;
import com.example.horasunab.model.entity.Evento;
import com.example.horasunab.model.repository.EventoRepository;

public class ListDetailActivity extends AppCompatActivity {

    private int CODIGO_EDITAR_EVENTO = 200;

    private ImageView ivDetalle;
    private TextView tvTitulo, tvFecha, tvHora, tvDesc, tvLink, tvAmountHr;
    private Button btDelete, btUpdate;
    private Evento miEvento;
    private EventoRepository eventoRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_detail);

        ivDetalle = findViewById(R.id.iv_detail_student_image);
        tvTitulo = (TextView) findViewById(R.id.tv_detail_student_tittle);
        tvFecha = findViewById(R.id.tv_detail_student_date);
        tvHora = findViewById(R.id.tv_detail_student_hour);
        tvDesc = findViewById(R.id.tv_detail_student_desc);
        tvLink = findViewById(R.id.tv_detail_student_link);
        tvAmountHr = findViewById(R.id.tv_list_amount_item_detail_student);
        btDelete = findViewById(R.id.bt_detail_student_save);
        btUpdate = findViewById(R.id.bt_detail_edit);

        eventoRepository = new EventoRepository(ListDetailActivity.this);
        miEvento = (Evento) getIntent().getSerializableExtra("evento");
        loadView();

        btDelete.setOnClickListener(view -> {
            eventoRepository.eliminarEvento(miEvento);
            setResult(RESULT_OK);
            finish();
        });

        btUpdate.setOnClickListener(view -> {
            Intent i = new Intent(ListDetailActivity.this, FormActivity.class);
            i.putExtra("evento", miEvento);
            startActivityForResult(i, CODIGO_EDITAR_EVENTO);
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            if(requestCode == CODIGO_EDITAR_EVENTO && resultCode==RESULT_OK){
                miEvento = (Evento) data.getSerializableExtra("eventoDetalle");
                loadView();
            }
    }

    public void loadView(){

        tvTitulo.setText(miEvento.getNombreEvento());
        tvFecha.setText(getString(R.string.txt_detail_fecha, miEvento.getFechaEvento()));
        tvHora.setText(getString(R.string.txt_detail_hora, String.valueOf(miEvento.getHoraEvento())));
        tvDesc.setText(miEvento.getDescripcionEvento());
        tvLink.setText(getString(R.string.txt_detail_lugar, miEvento.getLugarEvento()));
        tvAmountHr.setText(getString(R.string.txt_detail_amount_hours, String.valueOf(miEvento.getCantidadHoras())));
        Glide.with(ListDetailActivity.this).load(miEvento.getUrlImagen()).into(ivDetalle);
    }

    @Override
    public void onBackPressed() {
        Intent iData = new Intent();
        setResult(RESULT_OK, iData);
        super.onBackPressed();
    }
}