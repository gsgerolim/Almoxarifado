package com.example.almoxarifado.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.almoxarifado.Model.Material;

import java.util.ArrayList;
import java.util.List;

public class MaterialDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    //conexão do banco de dados de DAO com conexão java
    public MaterialDAO(Context context) {
        this.conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    //inserindo um material
    public long inserir(Material material) {

        // insert into material values(...)
        // --> valores que vão ser inseridos no SQL

        ContentValues values = new ContentValues();
        values.put("codigo", material.getCodigo());
        values.put("nome", material.getNome());
        values.put("saldo", material.getSaldo());

        //manda os ids(codigos) retornarem para a função inserir
        return banco.insert("material", null, values);
    }

    //buscar todos os itens da tabela
    //SELECT * FROM material
    //SELECT * FROM material where cogido = 1;

    public List<Material> listarTodos() {
        //criando um ponteiro
        //para acesso a tabela

        Cursor cursor = banco.query(
                "material", new String[]{"codigo", "nome", "saldo"}, null, null, null, null, null, null
        );

        List<Material> materiaisCadastros = new ArrayList<>();
        while (cursor.moveToNext()){
            Material materialEncontrado = new Material();
            materialEncontrado.setCodigo(cursor.getInt(0));
            materialEncontrado.setNome(cursor.getString(1));
            materialEncontrado.setSaldo(cursor.getDouble(2));
            materiaisCadastros.add(materialEncontrado);
        }

        return materiaisCadastros;

    }

}
