package com.example.almoxarifado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.almoxarifado.Controller.MaterialController;
import com.example.almoxarifado.Model.Material;



public class teladecadastro extends AppCompatActivity {

    MaterialController materialController = new MaterialController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teladecadastro);

        EditText codigo = findViewById(R.id.edtcodmat);
        EditText nome = findViewById(R.id.edtnomemat);
        EditText saldo = findViewById(R.id.edtquantmat);
        Button btncad = findViewById(R.id.btncad);

     btncad.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
         esconderTeclado(teladecadastro.this, view);
        Material materialCadastro = new Material();
        materialCadastro.setCodigo(Integer.parseInt(codigo.getText().toString()));
        materialCadastro.setNome(nome.getText().toString());
        materialCadastro.setSaldo(Double.parseDouble(saldo.getText().toString()));
        materialController.addMaterial(materialCadastro, view);
      }
      });

     }

     public static void esconderTeclado(Context context, View view){
         InputMethodManager imn = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
         imn.hideSoftInputFromWindow(view.getWindowToken(), 0);
     }

     }