package com.example.almoxarifado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class telaCadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        EditText edtCodMaterial = (EditText) findViewById(R.id.edtCodMaterial);
        EditText edtNomeMaterial = (EditText) findViewById(R.id.edtNomeMaterial);
        EditText edtQtdMaterial = (EditText) findViewById(R.id.edtQtdMaterial);
        Button btnVoltarCadastro = (Button) findViewById(R.id.btnVoltarCadastro);

        btnVoltarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (telaCadastro.this , MainActivity.class);
                startActivity ( intent );
            }
        });

    }
}