package com.misiontic.finappmovil;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.misiontic.finappmovil.dao.UsuarioDao;
import com.misiontic.finappmovil.models.Usuario;

import java.util.ArrayList;

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

                if( (!valorUsuario.isEmpty() && !valorClave.isEmpty())){
                    Intent intent = new Intent(v.getContext(),MainActivity.class);
                    intent.putExtra("usuario",valorUsuario);
                    startActivity(intent);
                }else{
                    /*AlertDialog.Builder mensaje = new AlertDialog.Builder(v.getContext());
                    mensaje.setTitle("Campos vacios");
                    mensaje.setMessage("Digite todos los campos");
                    mensaje.show();*/

                    Toast.makeText(v.getContext(), "Digite los campos requeridos. ",Toast.LENGTH_LONG).show();

                }
            }
        });

        Button btnPrueba = findViewById(R.id.btn_prueba);
        btnPrueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsuarioDao usuarioDao= new UsuarioDao(view.getContext());
                Usuario objeto = new Usuario("CC","2345","Andrea Felipina","af@gmail.com","123");
                usuarioDao.insertar(objeto);
                ArrayList<Usuario> usuariosGuardados= usuarioDao.listar();
                objeto.setNombre("Pepino genial");
                objeto.setClave("4321");

                //usuarioDao.actualizar(objeto);
                //System.out.println(usuarioDao.delete(objeto));
                //usuariosGuardados= usuarioDao.listar();
            }
        });
    }
}