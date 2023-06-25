package com.example.citas_medicas_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class ConsultarMedicos extends AppCompatActivity {
    private ListView listMedicos;
    private Button btnConsultar;
    private Button btnRegresar;
    private Button btnInicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_medicos);
        incialize();
        btnRegresar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent_regresar = new Intent(ConsultarMedicos.this, MainMedicos.class);
                startActivity(intent_regresar);
            }
        });
        btnInicio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent_inicio = new Intent(ConsultarMedicos.this, MainActivity.class);
                startActivity(intent_inicio);
            }
        });
    }

    private void incialize(){
        listMedicos = (ListView) findViewById(R.id.listMedicos);
        btnConsultar = (Button) findViewById(R.id.btnRegistrarMedico);
        btnRegresar = (Button) findViewById(R.id.btnRegresarM);
        btnInicio = (Button) findViewById(R.id.btnInicio);
    }
}