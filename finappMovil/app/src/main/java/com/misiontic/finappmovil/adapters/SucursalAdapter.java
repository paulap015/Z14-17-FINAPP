package com.misiontic.finappmovil.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.misiontic.finappmovil.R;
import com.misiontic.finappmovil.dao.BancoDao;
import com.misiontic.finappmovil.models.Sucursal;

import java.util.List;

public class SucursalAdapter extends ArrayAdapter<Sucursal> {

    private List<Sucursal> listado;
    private Context contexto;
    private int layout;

    private BancoDao bancoDao;
    public SucursalAdapter(@NonNull Context contexto, int layout, List<Sucursal> listado) {
        super(contexto,layout, listado);
        this.listado = listado;
        this.contexto = contexto;
        this.layout = layout;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent){
        View vista =convertView;
        if(vista==null){
            vista= LayoutInflater.from(this.contexto).inflate(R.layout.item_adapter_sucursal,null);
            Sucursal registro = this.listado.get(position);

            TextView banco = vista.findViewById(R.id.adapter_txtBanco);
            TextView tipoSucursal = vista.findViewById(R.id.adapter_txtTipoSucursal);

           // banco.setText(bancoDao.listarPorNit(registro.getNitBanco()).getNombre());
            banco.setText(registro.getNitBanco());
            tipoSucursal.setText(String.valueOf(registro.getTipoSucursal()));
        }
        return vista;
    }
}
