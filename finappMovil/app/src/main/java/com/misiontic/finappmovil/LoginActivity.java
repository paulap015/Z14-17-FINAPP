package com.misiontic.finappmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnAcceder = findViewById(R.id.login_btnAcceder);
        btnAcceder.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                EditText usuario = findViewById(R.id.login_txtUsuario);
                EditText clave = findViewById(R.id.login_txtClave);

                String valorUsuario = usuario.getText().toString();
                String valorClave = usuario.getText().toString();

                if(!valorUsuario.isEmpty() && !valorClave.isEmpty()){
                    Intent intent = new Intent(v.getContext(),MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}