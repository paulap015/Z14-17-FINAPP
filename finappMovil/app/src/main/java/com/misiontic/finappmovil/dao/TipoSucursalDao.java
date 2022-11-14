package com.misiontic.finappmovil.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.misiontic.finappmovil.classes.DBConnection;
import com.misiontic.finappmovil.models.Banco;
import com.misiontic.finappmovil.models.TipoSucursal;

import java.util.ArrayList;

public class TipoSucursalDao {
    private Context contexto;
    private final String nombreTabla ="tipo_sucursal";
    private DBConnection con;

    public TipoSucursalDao(Context contexto) {
        this.contexto = contexto;
        this.con=new DBConnection(contexto);
    }


    public long insertar(TipoSucursal modeloTipoSucursal){
        SQLiteDatabase bd =this.con.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put("id",modeloTipoSucursal.getId());
        valores.put("nombre",modeloTipoSucursal.getTipo());

        return bd.insert(this.nombreTabla,null,valores);
    }

    public ArrayList<TipoSucursal> listar(){
        SQLiteDatabase bd =this.con.getReadableDatabase();

        ArrayList<TipoSucursal> registros = new ArrayList<>();
        String[]columnasConsulta = {"id","tipo"};

        String condicionWhere ="";
        String[] valoresCondicionWhere = {};

        Cursor cursor = bd.query(this.nombreTabla,columnasConsulta,null,null,null,null,null);

        if(cursor!=null){
            cursor.moveToFirst();
            //System.out.println("IMPRIMIENDO"+ cursor.getString(3));
            do{

                TipoSucursal registro = new TipoSucursal(cursor.getInt(0),
                        cursor.getString(1)
                );

                registros.add(registro);
            }while(cursor.moveToNext());
            cursor.close();;
        }

        return registros;
    }
}
