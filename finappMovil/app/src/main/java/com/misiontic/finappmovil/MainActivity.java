package com.misiontic.finappmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Bundle datos=getIntent().getExtras();
        if(datos!=null){
            TextView usuario = findViewById(R.id.main_txtUser);
            usuario.setText(datos.getString("usuario"));
        }

        Button btnAbout = findViewById(R.id.btn_about);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://github.com/paulap015"));
                startActivity(intent);
            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton btnSalir = findViewById(R.id.main_btnSalir);
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed(); //devolverse
            }
        });

    }
}