package com.example.almoxarifado.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.almoxarifado.Model.Material;

import java.util.ArrayList;
import java.util.List;

//fazendo materialDAO se conectar com o banco de dados
public class MaterialDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public MaterialDAO(Context context){
        this.conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }
    //inserindo um material
    public long inserir(Material material){
        //insert into material values(...);
        ContentValues values = new ContentValues();
        values.put("codigo",material.getCodigo());
        values.put("nome", material.getNome());
        values.put("saldo",material.getSaldo());

        return banco.insert("material",null,values);
    }
    //buscar todos os item da tabela
    //select * from material;
    //select * from material where codigo=1;

    public List<Material> listarTodos(){
        //criando um ponteiro
        //para acesso a tabela
        Cursor cursor = banco.query(
                "material",new String[]{"codigo","nome","saldo"},null,null,null,null,null,null);

        List<Material> materiaisCadastrados =  new ArrayList<>();
        while (cursor.moveToNext()){
            Material materialEncontrado = new Material();
            materialEncontrado.setCodigo(cursor.getInt(0));
            materialEncontrado.setNome(cursor.getString(1));
            materialEncontrado.setSaldo(cursor.getDouble(2));
            materiaisCadastrados.add(materialEncontrado);
        }
        return materiaisCadastrados;



    }
}
