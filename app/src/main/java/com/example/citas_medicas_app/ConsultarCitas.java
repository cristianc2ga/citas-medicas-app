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

public class ConsultarCitas extends AppCompatActivity {
    private Button btnRegresar;
    private Button btnInicio;
    private ListView listCitas;

    private Button btnConsultar;

    private Database_admin obj_base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_citas);
        incialize();

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean confirm = obj_base.connectSQL();
                if (confirm) {
                    ArrayList<String> citas = obj_base.getCitas();
                    ArrayList<String> citasMostradas = new ArrayList<>();

                    // Separar los elementos por ";"
                    for (int i = 0; i < citas.size(); i++) {
                        String cita = citas.get(i);
                        String[] datosCita = cita.split(";");

                        // Obtener los campos individuales
                        int pacienteId = Integer.parseInt(datosCita[0]);
                        String nombresPaciente = datosCita[1];
                        String apellidosPaciente = datosCita[2];
                        String documentoPaciente = datosCita[3];
                        int medicoId = Integer.parseInt(datosCita[4]);
                        String nombresMedico = datosCita[5];
                        String apellidosMedico = datosCita[6];
                        String especialidad = datosCita[7];
                        String fecha = datosCita[8];

                        // Crear una cadena con los campos deseados
                        String citaMostrada = "Paciente: " + nombresPaciente + " " + apellidosPaciente + " (Documento: " + documentoPaciente + ")\n" +
                                "Médico: " + nombresMedico + " " + apellidosMedico + " (Especialidad: " + especialidad + ")\n" +
                                "Fecha Cita: " + fecha;

                        citasMostradas.add(citaMostrada);
                    }

                    // Crear un adaptador personalizado y asignarlo al ListView
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(ConsultarCitas.this, android.R.layout.simple_list_item_1, citasMostradas);
                    listCitas.setAdapter(adapter);
                    Toast.makeText(ConsultarCitas.this, "Success", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ConsultarCitas.this, "Failed", Toast.LENGTH_LONG).show();
                }
            }
        });


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
        btnConsultar = (Button) findViewById(R.id.btnConsultarCitas);
        listCitas = (ListView) findViewById(R.id.listCitas);
        btnRegresar = (Button) findViewById(R.id.btnRegresarC);
        btnInicio = (Button) findViewById(R.id.btnInicio);
        obj_base = new Database_admin();
    }
}