package com.example.citas_medicas_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMedicos extends AppCompatActivity {
    private Button btnRegistrarMedicos;
    private Button btnConsutlarMedicos;
    private Button btnRegresarM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_medicos);
        inicialize();

        btnRegistrarMedicos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent_Rmedicos = new Intent(MainMedicos.this, RegistroMedicos.class);
                startActivity(intent_Rmedicos);
            }
        });
        btnConsutlarMedicos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent_Cmedicos = new Intent(MainMedicos.this, ConsultarMedicos.class);
                startActivity(intent_Cmedicos);
            }
        });
        btnRegresarM.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent_regresarM = new Intent(MainMedicos.this, MainActivity.class);
                startActivity(intent_regresarM);
            }
        });
    }
    private void inicialize(){
        btnRegistrarMedicos = (Button) findViewById(R.id.btnRegistrarMedico);
        btnConsutlarMedicos = (Button) findViewById(R.id.btnConsultarMedicos);
        btnRegresarM = (Button) findViewById(R.id.btnRegresarM);


    }
}