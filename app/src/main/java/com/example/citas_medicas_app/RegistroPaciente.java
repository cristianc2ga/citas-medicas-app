package com.example.citas_medicas_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
    private Database_admin obj_base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_paciente);
        incialize();
        btnRegistro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               boolean confirm = obj_base.connectSQL();
                if(confirm){
                    Toast.makeText(RegistroPaciente.this,"Conexión BD correcta", Toast.LENGTH_LONG).show();
                    boolean confirm_registro = obj_base.insertPacientes(
                            txtNombre.getText().toString(),
                            txtApellido.getText().toString(),
                            txtDocumento.getText().toString(),
                            txtCorreo.getText().toString(),
                            txtCelular.getText().toString(),
                            txtNacimiento.getText().toString());
                    Toast.makeText(RegistroPaciente.this,"Usuario registrado correctamente", Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(RegistroPaciente.this,"Failed", Toast.LENGTH_LONG).show();
                }
            }
        });
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
        btnRegistro = (Button) findViewById(R.id.btnRegistro);
        btnRegresar = (Button) findViewById(R.id.btnRegresarP);
        btnInicio = (Button) findViewById(R.id.btnInicio);
        obj_base = new Database_admin();

    }
}