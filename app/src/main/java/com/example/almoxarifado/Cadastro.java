package com.example.almoxarifado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.almoxarifado.Controller.MaterialController;

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


                materialController.adcMaterial(edtCod, edtNome, edtQtd);
            }
        });
    }
}