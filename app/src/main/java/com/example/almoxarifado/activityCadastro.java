package com.example.almoxarifado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.almoxarifado.Controller.MaterialController;

public class activityCadastro extends AppCompatActivity {
    MaterialController materialController = new MaterialController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        Button btnCadastro = (Button) findViewById(R.id.btnCadastro);
        btnCadastro.setOnClickListener(new View.OnClickListener());
    }
}