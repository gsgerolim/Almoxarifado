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

public class CadastroProduto extends AppCompatActivity {
    MaterialController materialController = new MaterialController();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto);
        Button btnCadastraProduto = (Button) findViewById(R.id.btnCadastrar);
        EditText edtCod = (EditText) findViewById(R.id.edtCodCad);
        EditText edtNome = (EditText) findViewById(R.id.edtNomeCad);
        EditText edtQtd = (EditText) findViewById(R.id.edtSaldoCad);

        btnCadastraProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Material materialCadastro = new Material();
                materialCadastro.setCodigo(Integer.parseInt(edtCod.getText().toString()));
                materialCadastro.setNome(edtNome.getText().toString());
                materialCadastro.setSaldo(Double.parseDouble(edtQtd.getText().toString()));
                materialController.addMaterial(materialCadastro, v);
            }
        });

    }
    public static void esconderTeclado(Context context,View view){
        InputMethodManager inn=(InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        inn.hideSoftInputFromWindow(view.getWindowToken(), 0);
        //verificar comit 80
    }
}