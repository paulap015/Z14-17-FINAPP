package com.misiontic.finappmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.misiontic.finappmovil.adapters.SucursalAdapter;
import com.misiontic.finappmovil.dao.SucursalDao;
import com.misiontic.finappmovil.models.Sucursal;

import java.util.ArrayList;

public class ListarSucursalesActivity extends AppCompatActivity {

    private ListView listaSucursales;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_sucursales);

        this.listaSucursales = findViewById(R.id.listarSucursales_lista);

        SucursalDao bd = new SucursalDao(this);
        ArrayList<Sucursal> listado = bd.listar();

        SucursalAdapter adaptador = new SucursalAdapter(this, R.layout.item_adapter_sucursal,listado);
        listaSucursales.setAdapter(adaptador);
    }
}