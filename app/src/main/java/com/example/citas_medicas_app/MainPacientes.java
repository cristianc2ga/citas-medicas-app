package com.example.citas_medicas_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainPacientes extends AppCompatActivity {
    private Button btnRegistrarPacientes;
    private Button btnConsutlarPacientes;
    private Button btnRegresarPacientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pacientes);
        inicialize();

        btnRegistrarPacientes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent_RMpacientes = new Intent(MainPacientes.this, RegistroPaciente.class);
                startActivity(intent_RMpacientes);
            }
        });
        btnConsutlarPacientes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent_CMpacientes = new Intent(MainPacientes.this, ConsultarPacientes.class);
                startActivity(intent_CMpacientes);
            }
        });
        btnRegresarPacientes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent_regresar = new Intent(MainPacientes.this, MainActivity.class);
                startActivity(intent_regresar);
            }
        });
    }
    private void inicialize(){
        btnRegistrarPacientes = (Button) findViewById(R.id.btnRegistrarPacientes);
        btnConsutlarPacientes = (Button) findViewById(R.id.btnConsultarPacientes);
        btnRegresarPacientes = (Button) findViewById(R.id.btnRegresarP);


    }
}