package com.example.citas_medicas_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class RegistroCita extends AppCompatActivity {
    private Spinner spinnerPacientes;
    private Spinner spinnerMedicos;

    private EditText txtFechaCita;
    private Button btnRegresarCitas;
    private Button btnInicio;
    private Button btnRegistrarCita;
    private Database_admin obj_base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_cita);
        inicialize();
        boolean confirm = obj_base.connectSQL();
        if (confirm) {
            ArrayList<String> pacientes = obj_base.getPacientes();
            ArrayList<String> medicos = obj_base.getMedicos();

            // Crear lista de pacientes con nombre, apellidos y documento
            ArrayList<String> pacientesNombres = new ArrayList<>();
            for (String paciente : pacientes) {
                String[] datosPaciente = paciente.split(";");
                String pacienteNombre = datosPaciente[1] + " " + datosPaciente[2] + " - " + datosPaciente[3];
                pacientesNombres.add(pacienteNombre);
            }

            // Crear lista de médicos con nombre, apellidos y especialidad
            ArrayList<String> medicosNombres = new ArrayList<>();
            for (String medico : medicos) {
                String[] datosMedico = medico.split(";");
                String medicoNombre = datosMedico[1] + " " + datosMedico[2] + " - " + datosMedico[6];
                medicosNombres.add(medicoNombre);
            }

            ArrayAdapter<String> adapterPacientes = new ArrayAdapter<>(RegistroCita.this, android.R.layout.simple_spinner_item, pacientesNombres);
            adapterPacientes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerPacientes.setAdapter(adapterPacientes);

            ArrayAdapter<String> adapterMedicos = new ArrayAdapter<>(RegistroCita.this, android.R.layout.simple_spinner_item, medicosNombres);
            adapterMedicos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerMedicos.setAdapter(adapterMedicos);

            Toast.makeText(RegistroCita.this, "Success", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(RegistroCita.this, "Failed", Toast.LENGTH_LONG).show();
        }

        btnRegistrarCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean confirm = obj_base.connectSQL();
                if (confirm) {
                    Toast.makeText(RegistroCita.this, "Conexión BD correcta", Toast.LENGTH_LONG).show();

                    // Obtener el paciente seleccionado
                    int pacienteIndex = spinnerPacientes.getSelectedItemPosition();
                    ArrayList<String> pacientes = obj_base.getPacientes();
                    String pacienteSeleccionado = pacientes.get(pacienteIndex);
                    String[] datosPaciente = pacienteSeleccionado.split(";");
                    int pacienteId = Integer.parseInt(datosPaciente[0]);

                    // Obtener el médico seleccionado
                    int medicoIndex = spinnerMedicos.getSelectedItemPosition();
                    ArrayList<String> medicos = obj_base.getMedicos();
                    String medicoSeleccionado = medicos.get(medicoIndex);
                    String[] datosMedico = medicoSeleccionado.split(";");
                    int medicoId = Integer.parseInt(datosMedico[0]);

                    // Obtener la fecha de la cita
                    String fechaCita = txtFechaCita.getText().toString();

                    // Crear un objeto ModelCita con los datos de la cita
                    ModelCita cita = new ModelCita(pacienteId, medicoId, fechaCita);

                    try {
                        // Registrar la cita en la base de datos
                        boolean confirmRegistro = obj_base.insertCita(cita);

                        // Mostrar los IDs en un Toast para verificar
                        //Toast.makeText(RegistroCita.this, "pacienteId: " + pacienteId + ", medicoId: " + medicoId + ", fecha: " + fechaCita, Toast.LENGTH_LONG).show();

                        if (confirmRegistro) {
                            Toast.makeText(RegistroCita.this, "Cita registrada correctamente", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(RegistroCita.this, "Error al registrar la cita", Toast.LENGTH_LONG).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(RegistroCita.this, "Error al insertar la cita", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(RegistroCita.this, "Failed", Toast.LENGTH_LONG).show();
                }
            }
        });

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
        spinnerPacientes = (Spinner) findViewById(R.id.spinner);
        spinnerMedicos = (Spinner) findViewById(R.id.spinnerMed);
        txtFechaCita = (EditText) findViewById(R.id.txtFechaCita);
        btnRegresarCitas = (Button) findViewById(R.id.btnRegresarCitas);
        btnInicio = (Button) findViewById(R.id.btnInicio);
        btnRegistrarCita = (Button) findViewById(R.id.btnRegistrarCita);
        obj_base = new Database_admin();

    }
}