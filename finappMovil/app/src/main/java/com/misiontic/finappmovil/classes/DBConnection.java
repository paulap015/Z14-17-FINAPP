package com.misiontic.finappmovil.classes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBConnection  extends SQLiteOpenHelper {

    private static final String nameDB="DBfinapp";
    private static final int version=1;
    public DBConnection(@Nullable Context context) {
        super(context, nameDB, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE usuario (\n" +
                "    id             INTEGER      PRIMARY KEY AUTOINCREMENT NOT NULL ,\n" +
                "    tipo_documento VARCHAR,\n" +
                "    documento      VARCHAR (20) NOT NULL,\n" +
                "    nombre         VARCHAR (40) NOT NULL,\n" +
                "    correo         VARCHAR (30) NOT NULL,\n" +
                "    clave          VARCHAR (80) NOT NULL\n" +
                ")");

        db.execSQL("CREATE TABLE banco (\n" +
                "    id     INTEGER      PRIMARY KEY AUTOINCREMENT\n" +
                "                        NOT NULL,\n" +
                "    nombre VARCHAR (30) NOT NULL,\n" +
                "    nit    VARCHAR (30) NOT NULL UNIQUE\n" +
                ")");
        db.execSQL("CREATE TABLE sucursal (\n" +
                "    id                         PRIMARY KEY AUTOINCREMENT\n" +
                "                               NOT NULL,\n" +
                "    tipo_sucursal INTEGER      NOT NULL,\n" +
                "    nit_banco     VARCHAR (30) NOT NULL,\n" +
                "    direccion     VARCHAR (30) NOT NULL\n" +
                ");");

        System.out.println("IMPRIMIENDO banco creado ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
