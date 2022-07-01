package com.example.horasunab.view.activitys;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.example.horasunab.R;
import com.example.horasunab.model.entity.Evento;
import com.example.horasunab.model.repository.EventoRepository;
import com.example.horasunab.view.adapter.EventoAdapter;

import java.util.List;

public class ListAdminActivity extends AppCompatActivity{

    private int CODIGO_DETALLE_EVENTO = 100;
    private int CODIGO_AGREGAR_EVENTO = 101;

    private List<Evento> listadoEventos;
    private RecyclerView rvEventos;
    private EventoAdapter miAdapter;
    private EventoRepository eventoRepository;
    private Button btAgregar;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_appbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.btnLogout){
            Intent i = new Intent(ListAdminActivity.this, MainActivity.class);
            startActivity(i);
            Toast.makeText(ListAdminActivity.this, "Logout", Toast.LENGTH_SHORT).show();
            finish();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_admin);

        rvEventos = findViewById(R.id.rv_activity_liststudent);
        btAgregar = findViewById(R.id.bt_create_list);

        eventoRepository = new EventoRepository(ListAdminActivity.this);

        loadEvents();
        miAdapter = new EventoAdapter(listadoEventos);
        rvEventos.setAdapter(miAdapter);
        rvEventos.setLayoutManager(new LinearLayoutManager(ListAdminActivity.this));
        rvEventos.setHasFixedSize(true);

        miAdapter.setOnItemClickListener(new EventoAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(Evento miEvento) {
                Intent i = new Intent(ListAdminActivity.this, ListDetailActivity.class);
                i.putExtra("evento", miEvento);
                startActivityForResult(i, CODIGO_DETALLE_EVENTO);
            }
        });

        btAgregar.setOnClickListener(view -> {
            Intent i = new Intent(ListAdminActivity.this, FormActivity.class);
            startActivityForResult(i, CODIGO_AGREGAR_EVENTO);
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CODIGO_DETALLE_EVENTO && resultCode==RESULT_OK){
           /* if (data != null){
                Evento miEvento = (Evento) data.getSerializableExtra("evento");
                Boolean editar = data.getBooleanExtra("editar", false);
                miAdapter.setListadoEvento(listadoEventos);
            }*/
            loadEvents();
            miAdapter.setListadoEvento(listadoEventos);
        }

        if(requestCode == CODIGO_AGREGAR_EVENTO && resultCode==RESULT_OK){
            loadEvents();
            miAdapter.setListadoEvento(listadoEventos);
        }
    }


    private void loadEvents(){

        listadoEventos = eventoRepository.obtenerEventos();

        if(listadoEventos.isEmpty()){
            loadFakeEvent();

        }
    }

    private void loadFakeEvent(){
        eventoRepository.agregarEvento(new Evento("Psicologia", 2, "https://www.unir.net/wp-content/uploads/2020/10/psicologia-clinica-1024x903.jpg", 16, "23/12/2021", "Link", "Bienvenidos"));
        eventoRepository.agregarEvento(new Evento("Salud Mental", 3, "https://d2lcsjo4hzzyvz.cloudfront.net/blog/wp-content/uploads/2021/11/11122045/Recomendaciones-para-cuidar-la-salud-mental-en-esta-e%CC%81poca-.jpg", 16, "23/12/2021", "Link", "hola buenos dias"));

        loadEvents();
    }
}