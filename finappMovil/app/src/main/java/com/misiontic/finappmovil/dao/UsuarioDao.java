package com.misiontic.finappmovil.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.misiontic.finappmovil.classes.DBConnection;
import com.misiontic.finappmovil.models.Usuario;

import java.util.ArrayList;

public class UsuarioDao {
    private Context contexto;
    private final String nombreTabla ="usuario";
    private DBConnection con;

    public UsuarioDao(Context contexto) {
        this.contexto = contexto;
        this.con=new DBConnection(contexto);
    }


    public long insertar(Usuario modeloUsuario){
        SQLiteDatabase bd =this.con.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("id",modeloUsuario.getId());
        valores.put("tipo_documento",modeloUsuario.getTipoDocumento());
        valores.put("documento",modeloUsuario.getDocumento());
        valores.put("nombre",modeloUsuario.getNombre());
        valores.put("correo",modeloUsuario.getCorreo());
        valores.put("clave",modeloUsuario.getClave());

        return bd.insert(this.nombreTabla,null,valores);
    }

    public ArrayList<Usuario> listar(){
        SQLiteDatabase bd =this.con.getReadableDatabase();

        ArrayList<Usuario> registros = new ArrayList<>();
        String[]columnasConsulta = {"tipo_documento","documento","nombre","correo","clave"};
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

                Usuario registro = new Usuario(cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)
                );

                registros.add(registro);
            }while(cursor.moveToNext());
            cursor.close();;
        }

        return registros;
    }

    public int actualizar(Usuario modeloUsuario){
        SQLiteDatabase db = this.con.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("tipo_documento",modeloUsuario.getTipoDocumento());
        valores.put("documento",modeloUsuario.getDocumento());
        valores.put("nombre",modeloUsuario.getNombre());
        valores.put("clave",modeloUsuario.getClave());

        System.out.println("IMPRIMIENO "+modeloUsuario.getDocumento());
        String criterioWhere="documento = ?";
        String[] argumentosCriterioWhere={modeloUsuario.getDocumento()};
        return db.update(this.nombreTabla,valores,criterioWhere,argumentosCriterioWhere);

    }
    public int delete(Usuario modeloUsuario){
        SQLiteDatabase db = this.con.getWritableDatabase();

        String criterioWhere="documento = ?";
        String[] argumentosCriterioWhere={modeloUsuario.getDocumento()};

        return db.delete(this.nombreTabla,criterioWhere,argumentosCriterioWhere);
    }
}
