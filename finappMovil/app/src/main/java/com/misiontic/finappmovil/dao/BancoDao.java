package com.misiontic.finappmovil.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.misiontic.finappmovil.classes.DBConnection;
import com.misiontic.finappmovil.models.Banco;
import com.misiontic.finappmovil.models.Usuario;

import java.util.ArrayList;

public class BancoDao {
    private Context contexto;
    private final String nombreTabla ="banco";
    private DBConnection con;

    public BancoDao(Context contexto) {
        this.contexto = contexto;
        this.con=new DBConnection(contexto);
    }


    public long insertar(Banco modeloBanco){
        SQLiteDatabase bd =this.con.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put("id",modeloBanco.getId());
        valores.put("nombre",modeloBanco.getNombre());
        valores.put("nit",modeloBanco.getNit());

        return bd.insert(this.nombreTabla,null,valores);
    }

    public ArrayList<Banco> listar(){
        SQLiteDatabase bd =this.con.getReadableDatabase();

        ArrayList<Banco> registros = new ArrayList<>();
        String[]columnasConsulta = {"id","nombre","nit"};
        /*String condicionWhere ="tipo_documento=? and documento";
        String[] valoresCondicionWhere = {"CC","123"};*/
        String condicionWhere ="";
        String[] valoresCondicionWhere = {};

        Cursor cursor = bd.query(this.nombreTabla,columnasConsulta,null,null,null,null,null);
        //Cursor cursor = bd.query(this.nombreTabla,columnasConsulta,condicionWhere,valoresCondicionWhere,null,null,null);

        if(cursor!=null){
            cursor.moveToFirst();
            //System.out.println("IMPRIMIENDO"+ cursor.getString(3));
            do{

                Banco registro = new Banco(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2)
                );

                registros.add(registro);
            }while(cursor.moveToNext());
            cursor.close();;
        }

        return registros;
    }

    public ArrayList<Banco> listarPorNombre(String nombre){
        SQLiteDatabase bd =this.con.getReadableDatabase();

        ArrayList<Banco> registros = new ArrayList<>();
        String[]columnasConsulta = {"id","nombre","nit"};
        String condicionWhere ="nombre LIKE '%?%'";
        String[] valoresCondicionWhere = {nombre};


        Cursor cursor = bd.query(this.nombreTabla,columnasConsulta,condicionWhere,valoresCondicionWhere,null,null,null);

        if(cursor!=null){
            cursor.moveToFirst();
            //System.out.println("IMPRIMIENDO"+ cursor.getString(3));
            do{

                Banco registro = new Banco(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2)
                );

                registros.add(registro);
            }while(cursor.moveToNext());
            cursor.close();;
        }

        return registros;
    }
    public Banco listarPorNit(String nombre){
        SQLiteDatabase bd =this.con.getReadableDatabase();

        Banco registro = null;
        String[]columnasConsulta = {"id","nombre","nit"};
        String condicionWhere ="nombre LIKE '%?%'";
        String[] valoresCondicionWhere = {nombre};


        Cursor cursor = bd.query(this.nombreTabla,columnasConsulta,condicionWhere,valoresCondicionWhere,null,null,null);

        if(cursor!=null){
            cursor.moveToFirst();
            registro = new Banco(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2)
            );

            cursor.close();

        }

        return registro;
    }


}
