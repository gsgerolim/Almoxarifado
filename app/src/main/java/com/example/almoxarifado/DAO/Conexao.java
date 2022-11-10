package com.example.almoxarifado.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexao extends SQLiteOpenHelper {

    //constaste que guarda o nome do Bando de Dados
    private static final String BANCO = "almoxerifado.db";
    private static final int VERSION = 1;

    public Conexao(Context context){

        super(context, BANCO, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table material(" +
                "codigo primary key," +
                "nome varchar(50)," +
                "saldo interger" +
                ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
