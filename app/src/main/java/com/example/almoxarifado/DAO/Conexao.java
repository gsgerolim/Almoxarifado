package com.example.almoxarifado.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexao extends SQLiteOpenHelper
{

    private static final String BANCO = "almoxarifado.db";
    //constante que guarda nome do banco de dados//
    private static final int VERSION = 1;

    public Conexao(Context context){
     super(context, BANCO, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("Create table material(" +
                "codigo primary key," +
                "nome varchar (50)," +
                "saldo integer" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
