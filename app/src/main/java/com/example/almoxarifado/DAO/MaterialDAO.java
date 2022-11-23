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

    public MaterialDAO(Context context){
        this.conexao =  new Conexao(context);
        //MaterialDAO vai manipular com o banco e se conecta para manipulação.//

        banco = conexao.getWritableDatabase();

    }
    //inserindo um material
    public long inserir(Material material){
        //insert into material values(...);
        ContentValues values = new ContentValues(); //valores a inserir na SQL
        values.put("cod", material.getCodigo());
                values.put("nome",material.getNome());
                        values.put("saldo", material.getSaldo());

                        return banco.insert("material", null, values);
                        //retornando Long para onde chamar a classe
    }
    //buscar todos itens da tabela
    public List <Material> listarTodos(){
     Cursor cursor =  banco.query(
             "material", new String[]{"codigo","nome","saldo"},null,null,null,null,null, null

     );
        List<Material>materiaisCadastrados = new ArrayList<>();
        while (cursor.moveToNext()){
            Material materialEncontrado = new Material();
            materialEncontrado.setCodigo(cursor.getInt(0));
            materialEncontrado.setNome(cursor.getString(1));
            materialEncontrado.setSaldo(cursor.getInt(2));
            materiaisCadastrados.add (materialEncontrado);

        }
        return materiaisCadastrados;
    }
}