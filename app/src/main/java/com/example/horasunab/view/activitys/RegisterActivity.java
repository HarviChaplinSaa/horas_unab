package com.example.horasunab.view.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.horasunab.R;
import com.example.horasunab.model.entity.Usuario;
import com.example.horasunab.model.repository.UsuarioRepository;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {

    private String uid, name, lastname, email, career, password, confirmpassword;
    private boolean typeuser;
    private TextInputLayout et_uid, et_name, et_lastname, et_email, et_career, et_password, et_confirmpassword;
    private Button bt_register, bt_login;
    private UsuarioRepository usuarioRepository;
    private Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_uid = (TextInputLayout) findViewById(R.id.et_register_id);
        et_name = (TextInputLayout) findViewById(R.id.et_register_name);
        et_lastname = (TextInputLayout) findViewById(R.id.et_register_lastname);
        et_email = (TextInputLayout) findViewById(R.id.et_register_email);
        et_career = (TextInputLayout) findViewById(R.id.et_register_password);
        et_password = (TextInputLayout) findViewById(R.id.et_register_password);
        et_confirmpassword = (TextInputLayout) findViewById(R.id.et_register_confirmpassword);

        bt_login = findViewById(R.id.bt_register_login);
        bt_register = findViewById(R.id.bt_register_register);

        usuarioRepository = new UsuarioRepository(RegisterActivity.this);

        bt_register.setOnClickListener(view -> {
            uid = et_uid.getEditText().getText().toString();
            name = et_name.getEditText().getText().toString();
            lastname = et_lastname.getEditText().getText().toString();
            email = et_email.getEditText().getText().toString();
            career = et_career.getEditText().getText().toString();
            password = et_password.getEditText().getText().toString();
            confirmpassword = et_confirmpassword.getEditText().getText().toString();
            typeuser = false;

            user = new Usuario(uid, name, lastname, password, career, email, typeuser);

            if (user.isNull()){
                Toast.makeText(RegisterActivity.this, "Porfavor llenar todos los datos", Toast.LENGTH_SHORT).show();
            }else{
                if(password.equals(confirmpassword)){
                    usuarioRepository.agregarUsuario(user);
                    Intent i = new Intent(RegisterActivity.this, MainActivity.class);
                    Toast.makeText(RegisterActivity.this, "Usuario registrado con exito", Toast.LENGTH_SHORT).show();
                    startActivity(i);
                }else{
                    Toast.makeText(RegisterActivity.this, "La contraseña no coincide", Toast.LENGTH_SHORT).show();
                }
            }


        });

        bt_login.setOnClickListener(view -> {
            Intent i = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(i);
        });
    }
}