package com.example.citas_medicas_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class ConsultarCitas extends AppCompatActivity {
    private Button btnRegresar;
    private Button btnInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_citas);
        incialize();
        btnRegresar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent_regresar = new Intent(ConsultarCitas.this, MainCitas.class);
                startActivity(intent_regresar);
            }
        });
        btnInicio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent_inicio = new Intent(ConsultarCitas.this, MainActivity.class);
                startActivity(intent_inicio);
            }
        });
    }
    private void incialize(){
        btnRegresar = (Button) findViewById(R.id.btnRegresarC);
        btnInicio = (Button) findViewById(R.id.btnInicio);
    }
}