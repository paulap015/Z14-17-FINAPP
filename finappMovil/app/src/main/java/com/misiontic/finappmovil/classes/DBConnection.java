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

        /*db.execSQL("DROP TABLE IF EXISTS usuario;");
        db.execSQL("DROP TABLE IF EXISTS banco;");
        db.execSQL("DROP TABLE IF EXISTS tipo_sucursal;");
        db.execSQL("DROP TABLE IF EXISTS sucursal;");
        db.execSQL("DROP TABLE IF EXISTS horario;");
        db.execSQL("DROP TABLE IF EXISTS horario_sucursal;");*/
        db.execSQL("CREATE TABLE usuario (\n" +
                "    id             INTEGER      PRIMARY KEY AUTOINCREMENT NOT NULL ,\n" +
                "    tipo_documento VARCHAR,\n" +
                "    documento      VARCHAR (20) NOT NULL,\n" +
                "    nombre         VARCHAR (40) NOT NULL,\n" +
                "    correo         VARCHAR (30) NOT NULL,\n" +
                "    clave          VARCHAR (80) NOT NULL\n" +
                ");");

        db.execSQL("CREATE TABLE banco (\n" +
                "    id     INTEGER      PRIMARY KEY AUTOINCREMENT\n" +
                "                        NOT NULL,\n" +
                "    nombre VARCHAR (30) NOT NULL,\n" +
                "    nit    VARCHAR (30) NOT NULL UNIQUE\n" +
                ");");

        db.execSQL("CREATE TABLE tipo_sucursal (\n" +
                "    id     INTEGER      PRIMARY KEY AUTOINCREMENT,\n" +
                "    nombre VARCHAR (30) NOT NULL\n" +
                ");");

        db.execSQL("CREATE TABLE sucursal (\n" +
                "    id            INTEGER      PRIMARY KEY AUTOINCREMENT ,\n" +
                "    tipo_sucursal INTEGER      NOT NULL,\n" +
                "    nit_banco     VARCHAR (30) NOT NULL,\n" +
                "    direccion     VARCHAR (30) NOT NULL\n" +
                ");");
        db.execSQL("CREATE TABLE horario (\n" +
                "    id    INTEGER      PRIMARY KEY AUTOINCREMENT\n" +
                "                       NOT NULL,\n" +
                "    dia   VARCHAR (20) NOT NULL,\n" +
                "    rango VARCHAR (40) NOT NULL\n" +
                ");\n");

        db.execSQL("CREATE TABLE horario_sucursal (\n" +
                "    id         INTEGER PRIMARY KEY AUTOINCREMENT\n" +
                "                       NOT NULL,\n" +
                "    sucursalId INTEGER NOT NULL,\n" +
                "    horarioId  INTEGER NOT NULL\n" +
                ");");

        db.execSQL("insert into sucursal (id, tipo_sucursal, nit_banco, direccion) values" +
                "(1, 1, '172.222.250.122', 56.3452088),\n" +
                "(2, 3, '117.122.6.94', 48.8334498),\n" +
                "(3, 5, '196.93.49.29', 40.5420665),\n" +
                "(4, 1, '43.204.42.19', 35.1127371),\n" +
                "(5, 3, '145.38.149.53', 53.7117479);");

        db.execSQL("insert into banco (id,nombre,nit) values " +
                "(1,'Bancolombia','172.222.250.122'),\n" +
                "(2,'Nequi','117.122.6.94'),\n" +
                "(3,'Daviplata','196.93.49.29'),\n "+
                "(4,'Davivienda','43.204.42.19') \n");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
