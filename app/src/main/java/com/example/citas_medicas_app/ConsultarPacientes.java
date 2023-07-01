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

public class ConsultarPacientes extends AppCompatActivity {
    private ListView listPacientes;
    private Button btnConsultar;
    private Button btnRegresar;
    private Button btnInicio;

    private Database_admin obj_base;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_pacientes);
        incialize();

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean confirm = obj_base.connectSQL();
                if (confirm) {
                    ArrayList<String> pacientes = obj_base.getPacientes();

                    // Separar los elementos por ";"
                    for (int i = 0; i < pacientes.size(); i++) {
                        String paciente = pacientes.get(i);
                        String[] datosPaciente = paciente.split(";");
                        StringBuilder pacienteSeparado = new StringBuilder();
                        pacienteSeparado.append("Nombres: ").append(datosPaciente[1]).append("\n");
                        pacienteSeparado.append("Apellidos: ").append(datosPaciente[2]).append("\n");
                        pacienteSeparado.append("Documento: ").append(datosPaciente[3]).append("\n");
                        pacienteSeparado.append("Correo: ").append(datosPaciente[4]).append("\n");
                        pacienteSeparado.append("Celular: ").append(datosPaciente[5]).append("\n");
                        pacienteSeparado.append("Fecha de Nacimiento: ").append(datosPaciente[6]).append("\n");
                        pacientes.set(i, pacienteSeparado.toString());
                    }

                    // Crear un adaptador personalizado y asignarlo al ListView
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(ConsultarPacientes.this, android.R.layout.simple_list_item_1, pacientes);
                    listPacientes.setAdapter(adapter);
                    Toast.makeText(ConsultarPacientes.this, "Success", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ConsultarPacientes.this, "Failed", Toast.LENGTH_LONG).show();
                }
            }
        });


        btnRegresar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent_regresar = new Intent(ConsultarPacientes.this, MainPacientes.class);
                startActivity(intent_regresar);
            }
        });
        btnInicio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent_inicio = new Intent(ConsultarPacientes.this, MainActivity.class);
                startActivity(intent_inicio);
            }
        });

    }

    private void incialize(){
        listPacientes = (ListView) findViewById(R.id.listPacientes);
        btnConsultar = (Button) findViewById(R.id.btnConsultarPacientes);
        btnRegresar = (Button) findViewById(R.id.btnRegresarP);
        btnInicio = (Button) findViewById(R.id.btnInicio);
        obj_base = new Database_admin();

    }
}