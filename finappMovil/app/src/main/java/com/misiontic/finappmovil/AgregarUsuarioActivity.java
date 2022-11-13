package com.misiontic.finappmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.misiontic.finappmovil.dao.UsuarioDao;
import com.misiontic.finappmovil.models.Usuario;

public class AgregarUsuarioActivity extends AppCompatActivity {

    private EditText txtTipoDoc;
    private EditText txtDoc;
    private EditText txtNombre;
    private EditText txtCorreo;
    private EditText txtClave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_usuario);
        txtTipoDoc = findViewById(R.id.registro_txtTipoDoc);
        txtDoc = findViewById(R.id.registro_txtDocumento);
        txtNombre = findViewById(R.id.registro_txtNombre);
        txtCorreo = findViewById(R.id.registro_txtCorreo);
        txtClave = findViewById(R.id.registro_txtClave);

        Button btnGuardar = findViewById(R.id.registro_btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario modeloCargado=cargarModelo();
                if(modeloCargado!=null){
                    UsuarioDao bd = new UsuarioDao(v.getContext());
                    if(bd.insertar(modeloCargado)>0){
                        limpiarForm();
                        Toast.makeText(v.getContext(), "Se inserto el registro", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(v.getContext(), "Eror insertando registro", Toast.LENGTH_SHORT).show();

                    }
                }else{
                    Toast.makeText(v.getContext(), "Registre todos los campos", Toast.LENGTH_SHORT).show();

                }
            }
        });

        Button btnLogin = findViewById(R.id.registro_btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),LoginActivity.class);

                startActivity(intent);
            }
        });
    }

    public Usuario cargarModelo(){
        Usuario modelo=null;
        String tipDoc = txtTipoDoc.getText().toString();
        String documento=txtDoc.getText().toString();
        String nombre = txtNombre.getText().toString();
        String correo = txtCorreo.getText().toString();
        String clave = txtClave.getText().toString();

        if(!tipDoc.isEmpty() && !documento.isEmpty() && !nombre.isEmpty() && !correo.isEmpty() && !clave.isEmpty() ){
            modelo = new Usuario(tipDoc,documento,nombre,correo,clave);
        }
        return modelo;
    }
    private void limpiarForm(){
        txtTipoDoc.setText("");
        txtDoc.setText("");
        txtNombre.setText("");
        txtCorreo.setText("");
        txtClave.setText("");
    }
}