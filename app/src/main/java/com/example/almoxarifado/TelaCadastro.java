package com.example.almoxarifado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.almoxarifado.Controller.MaterialController;

public class TelaCadastro extends AppCompatActivity {
    MaterialController materialController = new MaterialController();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        Button btnEntrarT1 = (Button) findViewById(R.id.btnEntrarT1);
        Button btnCadastroT1 = (Button) findViewById(R.id.btnCadastroT1);

        btnEntrarT1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(TelaCadastro.this, TelaEntrar.class);
                startActivity(intent);
            }
        });

        btnCadastroT1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(TelaCadastro.this, TelaCadastrese.class);
                startActivity(intent);
            }
        });

    }
}