package com.example.citas_medicas_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistroPaciente extends AppCompatActivity {
    private EditText txtNombre;
    private EditText txtApellido;
    private EditText txtDocumento;
    private EditText txtCorreo;
    private EditText txtCelular;
    private EditText txtNacimiento;
    private Button btnRegistro;
    private Button btnRegresar;
    private Button btnInicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_paciente);
        incialize();
        btnRegresar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent_regresar = new Intent(RegistroPaciente.this, MainPacientes.class);
                startActivity(intent_regresar);
            }
        });
        btnInicio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent_inicio = new Intent(RegistroPaciente.this, MainActivity.class);
                startActivity(intent_inicio);
            }
        });
    }

    private void incialize(){
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtApellido = (EditText) findViewById(R.id.txtApellido);
        txtDocumento = (EditText) findViewById(R.id.txtDocumento);
        txtCorreo = (EditText) findViewById(R.id.txtCorreo);
        txtCelular = (EditText) findViewById(R.id.txtCelular);
        txtNacimiento = (EditText) findViewById(R.id.txtNacimiento);
        btnRegistro = (Button) findViewById(R.id.btnRegistrarMedico);
        btnRegresar = (Button) findViewById(R.id.btnRegresarP);
        btnInicio = (Button) findViewById(R.id.btnInicio);

    }
}