package com.example.citas_medicas_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistroCita extends AppCompatActivity {
    private Button btnRegresarCitas;
    private Button btnInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_cita);
        inicialize();
        btnRegresarCitas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent_regresar = new Intent(RegistroCita.this, MainCitas.class);
                startActivity(intent_regresar);
            }
        });
        btnInicio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent_inicio = new Intent(RegistroCita.this, MainActivity.class);
                startActivity(intent_inicio);
            }
        });
    }
    private void inicialize(){
        btnRegresarCitas = (Button) findViewById(R.id.btnRegresarCitas);
        btnInicio = (Button) findViewById(R.id.btnInicio);
    }
}