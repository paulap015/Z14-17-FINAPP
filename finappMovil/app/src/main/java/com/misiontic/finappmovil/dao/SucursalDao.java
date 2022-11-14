package com.misiontic.finappmovil.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.misiontic.finappmovil.classes.DBConnection;
import com.misiontic.finappmovil.models.Banco;
import com.misiontic.finappmovil.models.Sucursal;

import java.util.ArrayList;

public class SucursalDao {
    private Context contexto;
    private final String nombreTabla ="sucursal";
    private DBConnection con;

    public SucursalDao(Context contexto) {
        this.contexto = contexto;
        this.con=new DBConnection(contexto);
    }


    public long insertar(Sucursal modeloSucursal){
        SQLiteDatabase bd =this.con.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put("id",modeloSucursal.getId());
        valores.put("tipo_sucursal",modeloSucursal.getTipoSucursal());
        valores.put("nit_banco",modeloSucursal.getNitBanco());
        valores.put("direccion",modeloSucursal.getDireccion());

        return bd.insert(this.nombreTabla,null,valores);
    }

    public ArrayList<Sucursal> listar(){
        SQLiteDatabase bd =this.con.getReadableDatabase();

        ArrayList<Sucursal> registros = new ArrayList<>();
        String[]columnasConsulta = {"id","tipo_sucursal","nit_banco","direccion"};

        String condicionWhere ="";
        String[] valoresCondicionWhere = {};

        Cursor cursor = bd.query(this.nombreTabla,columnasConsulta,null,null,null,null,null);
        //Cursor cursor = bd.query(this.nombreTabla,columnasConsulta,condicionWhere,valoresCondicionWhere,null,null,null);

        if(cursor!=null){
            cursor.moveToFirst();
            //System.out.println("IMPRIMIENDO"+ cursor.getString(3));
            do{

                Sucursal registro = new Sucursal(cursor.getInt(0),
                        cursor.getInt(1),
                        cursor.getString(2),
                        cursor.getString(3)
                );

                registros.add(registro);
            }while(cursor.moveToNext());
            cursor.close();;
        }

        return registros;
    }
    public ArrayList<Sucursal> listarSucursalPorNit(String nit){
        SQLiteDatabase bd =this.con.getReadableDatabase();

        ArrayList<Sucursal> registros = new ArrayList<>();
        String[]columnasConsulta = {"id","tipo_sucursal","nit_banco","direccion"};
        String condicionWhere ="nit_banco =?";
        String[] valoresCondicionWhere = {nit};


        Cursor cursor = bd.query(this.nombreTabla,columnasConsulta,condicionWhere,valoresCondicionWhere,null,null,null);

        if(cursor!=null){
            cursor.moveToFirst();
            //System.out.println("IMPRIMIENDO"+ cursor.getString(3));
            do{

                Sucursal registro = new Sucursal(cursor.getInt(0),
                        cursor.getInt(1),
                        cursor.getString(2),
                        cursor.getString(3)
                );

                registros.add(registro);
            }while(cursor.moveToNext());
            cursor.close();;
        }

        return registros;
    }




}
