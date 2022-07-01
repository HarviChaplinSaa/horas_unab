package com.example.horasunab.view.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.horasunab.R;
import com.example.horasunab.model.entity.Evento;
import com.example.horasunab.model.repository.EventoRepository;
import com.example.horasunab.view.adapter.EventoAdapter;

import java.util.List;

public class ListStudentActivity extends AppCompatActivity {

    private int CODIGO_DETALLE_EVENTO = 301;
    private List<Evento> listadoEventos;
    private RecyclerView rvEventos;
    private EventoAdapter miAdapter;
    private EventoRepository eventoRepository;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_appbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.btnLogout){
            Intent i = new Intent(ListStudentActivity.this, MainActivity.class);
            startActivity(i);
            Toast.makeText(ListStudentActivity.this, "Logout", Toast.LENGTH_SHORT).show();
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_student);

        rvEventos = findViewById(R.id.rv_activity_liststudent);

        eventoRepository = new EventoRepository(ListStudentActivity.this);
        listadoEventos = eventoRepository.obtenerEventos();
        miAdapter = new EventoAdapter(listadoEventos);

        rvEventos.setAdapter(miAdapter);
        rvEventos.setLayoutManager(new LinearLayoutManager(ListStudentActivity.this));
        rvEventos.setHasFixedSize(true);

        miAdapter.setOnItemClickListener(new EventoAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(Evento miEvento) {
                Intent i = new Intent(ListStudentActivity.this, ListDetailStudentActivity.class);
                i.putExtra("evento", miEvento);
                startActivityForResult(i, CODIGO_DETALLE_EVENTO);
            }
        });
    }
}