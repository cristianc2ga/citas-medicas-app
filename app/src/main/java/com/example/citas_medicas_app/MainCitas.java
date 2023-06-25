package com.example.citas_medicas_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainCitas extends AppCompatActivity {
    private Button btnRegistrarCitas;
    private Button btnConsultarCitas;
    private Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_citas);
        inicialize();

        btnRegistrarCitas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent_Rcitas = new Intent(MainCitas.this, RegistroCita.class);
                startActivity(intent_Rcitas);
            }
        });
        btnConsultarCitas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent_Ccitas = new Intent(MainCitas.this, ConsultarCitas.class);
                startActivity(intent_Ccitas);
            }
        });
        btnRegresar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent_regresar = new Intent(MainCitas.this, MainActivity.class);
                startActivity(intent_regresar);
            }
        });
    }
    private void inicialize(){
        btnRegistrarCitas = (Button) findViewById(R.id.btnRegistrarCitas);
        btnConsultarCitas = (Button) findViewById(R.id.btnConsultarCitas);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);


    }
}