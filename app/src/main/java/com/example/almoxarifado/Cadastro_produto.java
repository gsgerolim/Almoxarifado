package com.example.almoxarifado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.almoxarifado.Controller.MaterialController;
import com.example.almoxarifado.Model.Material;

public class Cadastro_produto extends AppCompatActivity {
     MaterialController materialController = new MaterialController();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto);

        Button btnCadastro = (Button) findViewById(R.id.btnCadastro);
        EditText edtCodigo = (EditText)findViewById(R.id.edtCodigo);
        EditText edtNome_Produto = (EditText)findViewById(R.id.edtNome_Produto);
        EditText edtSaldo = (EditText)findViewById(R.id.edtSaldo);



        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Material materialCadastro = new Material();
                materialCadastro.setCodigo(Integer.parseInt(edtCodigo.getText().toString()));
                materialCadastro.setSaldo(Double.parseDouble(edtSaldo.getText().toString()));
                materialCadastro.setNome(edtNome_Produto.getText().toString());

                materialController.adcMaterial(materialCadastro);

            }
        });
    }
}