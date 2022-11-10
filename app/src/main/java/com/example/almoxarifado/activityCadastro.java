package com.example.almoxarifado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.almoxarifado.Controller.MaterialController;
import com.example.almoxarifado.Model.Material;

public class activityCadastro extends AppCompatActivity {
    MaterialController materialController = new MaterialController();

    MaterialController MaterialController = new MaterialController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        EditText nome = findViewById(R.id.edtNome);
        EditText codigo = findViewById(R.id.edtCodigo);
        EditText saldo = findViewById(R.id.edtSaldo);
        Button btncadastrar = findViewById(R.id.btnCadastro);

       btncadastrar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Material materialCadastro = new Material();
               materialCadastro.setCodigo(Integer.parseInt(codigo.getText().toString()));
               materialCadastro.setNome(nome.getText().toString());
               materialCadastro.setSaldo(Double.parseDouble(saldo.getText().toString()));
               materialController.addMaterial(materialCadastro);
           }
       });
    }
}