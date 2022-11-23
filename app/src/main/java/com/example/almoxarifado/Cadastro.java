package com.example.almoxarifado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.almoxarifado.Controller.MaterialController;
import com.example.almoxarifado.Model.Material;

public class Cadastro extends AppCompatActivity
{
    MaterialController materialController = new MaterialController();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //Botão
        Button btnConfCad = (Button) findViewById(R.id.btnConfCad);

        //Edits
        EditText edtCod = (EditText) findViewById(R.id.edtCodCad);
        EditText edtNome = (EditText) findViewById(R.id.edtNomeCad);
        EditText edtQtd = (EditText) findViewById(R.id.edtQuantCad);

        //Funcionalidade
        btnConfCad.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                esconderTeclado(Cadastro.class, view);
                Material materialCadastro = new Material();
                materialCadastro.setCodigo(Integer.parseInt(edtCod.getText().toString()));
                materialCadastro.setNome((edtNome.getText().toString()));
                materialCadastro.setSaldo(Double.parseDouble(edtQtd.getText().toString()));
                materialController.addMaterial(materialCadastro, view);
            }
        });
    }
                                     //contexto e qual tela estamos
    public static void esconderTeclado(Context context, View view)
    {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}