package com.example.horasunab.view.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.horasunab.R;
import com.example.horasunab.model.entity.Evento;

public class ListDetailStudentActivity extends AppCompatActivity {

    private TextView tvTitulo, tvFecha, tvHora, tvDesc, tvLink, tvAmountHr;
    private ImageView ivDetalle;
    private Evento miEvento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_detail_student);
        miEvento = (Evento) getIntent().getSerializableExtra("evento");
        inicializar();
        loadView();




    }

    private void loadView(){
        tvTitulo.setText(miEvento.getNombreEvento());
        tvFecha.setText(getString(R.string.txt_detail_fecha, miEvento.getFechaEvento()));
        tvHora.setText(getString(R.string.txt_detail_hora, String.valueOf(miEvento.getHoraEvento())));
        tvDesc.setText(miEvento.getDescripcionEvento());
        tvLink.setText(getString(R.string.txt_detail_lugar, miEvento.getLugarEvento()));
        tvAmountHr.setText(getString(R.string.txt_detail_amount_hours, String.valueOf(miEvento.getCantidadHoras())));
        Glide.with(ListDetailStudentActivity.this).load(miEvento.getUrlImagen()).into(ivDetalle);
    }

    private void inicializar(){
        tvTitulo = findViewById(R.id.tv_detail_student_tittle);
        tvFecha  = findViewById(R.id.tv_detail_student_date);
        tvHora = findViewById(R.id.tv_detail_student_hour);
        tvDesc = findViewById(R.id.tv_detail_student_desc);
        tvLink = findViewById(R.id.tv_detail_student_link);
        tvAmountHr = findViewById(R.id.tv_list_amount_item_detail_student);
        ivDetalle = findViewById(R.id.iv_detail_student_image);
    }

    @Override
    public void onBackPressed() {
        Intent iData = new Intent();
        setResult(RESULT_OK, iData);
        super.onBackPressed();
    }
}