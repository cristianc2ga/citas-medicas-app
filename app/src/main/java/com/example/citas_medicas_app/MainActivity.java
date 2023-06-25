package com.example.citas_medicas_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnPacientes;
    private Button btnMedicos;
    private Button btnCitas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicialize();

        btnPacientes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent_pacientes = new Intent(MainActivity.this, MainPacientes.class);
                startActivity(intent_pacientes);
            }
        });
        btnMedicos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent_medicos = new Intent(MainActivity.this, MainMedicos.class);
                startActivity(intent_medicos);
            }
        });
        btnCitas.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent_citas = new Intent(MainActivity.this, MainCitas.class);
                startActivity(intent_citas);
            }
        });
    }

    private void inicialize(){
        btnPacientes = (Button) findViewById(R.id.btnPacientes);
        btnMedicos = (Button) findViewById(R.id.btnMedicos);
        btnCitas = (Button) findViewById(R.id.btnCitas);

    }
}