package com.example.horasunab.view.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.horasunab.R;
import com.example.horasunab.model.entity.Usuario;
import com.example.horasunab.model.repository.UsuarioRepository;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tvTitulo;
    private TextInputLayout etUsuario;
    private TextInputLayout etPassword;
    private Button btnLogin, btnRegister;
    private List<Usuario> listaUsuarios;
    private UsuarioRepository usuarioRepository;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitulo = findViewById(R.id.tv_title_login);
        etUsuario = (TextInputLayout) findViewById(R.id.et_user_login);
        etPassword = (TextInputLayout) findViewById(R.id.et_password_login);
        btnLogin = findViewById(R.id.bt_login_login);
        btnRegister = findViewById(R.id.bt_login_register);

        preferences = this.getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        editor = preferences.edit();

        usuarioRepository = new UsuarioRepository(MainActivity.this);

        listaUsuarios = usuarioRepository.obtenerUsuarios();

        if (listaUsuarios.isEmpty()) {
            cargarAdminFake();
            cargarEstudianteFake();
        }

      /*  boolean logueado = preferences.getBoolean("login", false);
        boolean tipoUsuario = preferences.getBoolean("typeuser",false);

        Log.d("logueado", String.valueOf(logueado));
        Log.d("tipo", String.valueOf(tipoUsuario));

        if (logueado){
            if(tipoUsuario){
                Intent i = new Intent(MainActivity.this, ListAdminActivity.class);
                startActivity(i);
            }else{
                Intent i = new Intent(MainActivity.this, ListStudentActivity.class);
                startActivity(i);
            }
        }
        */
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuarioText = etUsuario.getEditText().getText().toString();
                //String passwordText = etPassword.getText().toString();
                String passwordText = etPassword.getEditText().getText().toString();

                if (usuarioText.isEmpty() || passwordText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Porfavor llenar los campos", Toast.LENGTH_SHORT).show();
                } else {
                    Usuario user = usuarioRepository.login(usuarioText, passwordText);
                    Log.d("TAG", "usuario" + usuarioText.isEmpty() );
                    Log.d("TAG", "password" + passwordText);
                    if (user == null) {
                        Toast.makeText(MainActivity.this, "Credenciales invalidas", Toast.LENGTH_SHORT).show();
                    } else {



                        if(user.isTipoUsuario()){
                           /* editor.putBoolean("logueado", true);
                            editor.putBoolean("typeuser",true);
                            editor.apply();*/
                            clearData();
                            Intent i = new Intent(MainActivity.this, ListAdminActivity.class);
                            i.putExtra("usuario", user);
                            startActivity(i);
                        }else{
                          /*  editor.putBoolean("logueado", true);
                            editor.putBoolean("typeuser",false);
                            editor.apply();*/
                            clearData();
                            Intent i = new Intent(MainActivity.this, ListStudentActivity.class);
                            i.putExtra("usuario", user);
                            startActivity(i);

                        }

                    }
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });

    }

    public void cargarAdminFake(){
        Usuario admin = new Usuario("U00123126", "Julian", "valderrama",
                "123","Ingenieria de sistemas", "yvalderrama@unab.edu.co", false);
        usuarioRepository.agregarUsuario(admin);
    }
    public void cargarEstudianteFake(){
        Usuario admin = new Usuario("U00111111", "Koke", "Galindo",
                "123","Admin", "koke@unab.edu.co", true);
        usuarioRepository.agregarUsuario(admin);
    }

    public void clearData(){
        etUsuario.getEditText().setText("");
        etPassword.getEditText().setText("");

    }

    /*  public boolean validarUsuario(List<Usuario> miLista, String usuario, String password){
        for (Usuario user:listaUsuarios) {
            if (user.getUid().equals(usuario) && user.getPassword().equals(password)){
                aux = user;
                return true;
            }
        }
        return false;
    }*/

}