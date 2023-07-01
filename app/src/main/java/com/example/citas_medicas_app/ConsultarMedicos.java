package com.example.citas_medicas_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ConsultarMedicos extends AppCompatActivity {
    private ListView listMedicos;
    private Button btnConsultar;
    private Button btnRegresar;
    private Button btnInicio;

    private Database_admin obj_base;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_medicos);
        incialize();

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean confirm = obj_base.connectSQL();
                if (confirm) {
                    ArrayList<String> medicos = obj_base.getMedicos();

                    // Separar los elementos por ";"
                    for (int i = 0; i < medicos.size(); i++) {
                        String medico = medicos.get(i);
                        String[] datosMedico = medico.split(";");
                        StringBuilder medicoSeparado = new StringBuilder();
                        medicoSeparado.append("Nombres: ").append(datosMedico[1]).append("\n");
                        medicoSeparado.append("Apellidos: ").append(datosMedico[2]).append("\n");
                        medicoSeparado.append("Documento: ").append(datosMedico[3]).append("\n");
                        medicoSeparado.append("Correo: ").append(datosMedico[4]).append("\n");
                        medicoSeparado.append("Celular: ").append(datosMedico[5]).append("\n");
                        medicoSeparado.append("Especialidad: ").append(datosMedico[6]).append("\n");
                        medicos.set(i, medicoSeparado.toString());
                    }

                    // Crear un adaptador personalizado y asignarlo al ListView
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(ConsultarMedicos.this, android.R.layout.simple_list_item_1, medicos);
                    listMedicos.setAdapter(adapter);
                    Toast.makeText(ConsultarMedicos.this, "Success", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ConsultarMedicos.this, "Failed", Toast.LENGTH_LONG).show();
                }
            }
        });

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
        btnConsultar = (Button) findViewById(R.id.btnConsultarMedicos);
        btnRegresar = (Button) findViewById(R.id.btnRegresarM);
        btnInicio = (Button) findViewById(R.id.btnInicio);
        obj_base = new Database_admin();

    }
}