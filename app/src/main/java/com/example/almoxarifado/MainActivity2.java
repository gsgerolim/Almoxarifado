package com.example.almoxarifado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.almoxarifado.Controller.MaterialController;
import com.example.almoxarifado.Model.Material;

public class MainActivity2 extends AppCompatActivity {
    MaterialController materialController = new MaterialController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        EditText edtCodigo = (EditText) findViewById(R.id.edtCodigo);
        EditText edtNome = (EditText) findViewById(R.id.edtNome);
        EditText edtSaldo = (EditText) findViewById(R.id.edtSaldo);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Material materialCadastro = new Material();
                materialCadastro.setCodigo(Integer.parseInt(edtCodigo.getText().toString()));
                materialCadastro.setNome(edtNome.getText().toString());
                materialCadastro.setSaldo(Double.parseDouble(edtSaldo.getText().toString()));
                materialController.addMaterial(materialCadastro, v);

            }
        });





    }
}