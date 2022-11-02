package com.example.almoxarifado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.almoxarifado.Controller.MaterialController;

public class MainActivity2 extends AppCompatActivity {
    MaterialController materialController =  new MaterialController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button btn1 = (Button) findViewById(R.id.btn1);
        EditText edt1 = (EditText) findViewById(R.id.edt1);
        EditText edt2 = (EditText) findViewById(R.id.edt2);
        EditText edt3 = (EditText) findViewById(R.id.edt3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              materialController.adcMaterial (edt1, edt2, edt3);
            }
        });



    }
}