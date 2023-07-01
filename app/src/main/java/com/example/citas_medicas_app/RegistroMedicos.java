package com.example.citas_medicas_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroMedicos extends AppCompatActivity {
    private EditText txtNombre;
    private EditText txtApellido;
    private EditText txtDocumento;
    private EditText txtCorreo;
    private EditText txtCelular;
    private EditText txtEspecialidad;
    private Button btnRegistroM;
    private Button btnRegresar;
    private Button btnInicio;
    private Database_admin obj_base;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_medicos);
        incialize();

        btnRegistroM.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                boolean confirm = obj_base.connectSQL();
                if(confirm){
                    Toast.makeText(RegistroMedicos.this,"Conexión BD correcta", Toast.LENGTH_LONG).show();
                    boolean confirm_registro = obj_base.insertMedicos(
                            txtNombre.getText().toString(),
                            txtApellido.getText().toString(),
                            txtDocumento.getText().toString(),
                            txtCorreo.getText().toString(),
                            txtCelular.getText().toString(),
                            txtEspecialidad.getText().toString());
                    Toast.makeText(RegistroMedicos.this,"Medico registrado correctamente", Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(RegistroMedicos.this,"Failed", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnRegresar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent_regresar = new Intent(RegistroMedicos.this, MainMedicos.class);
                startActivity(intent_regresar);
            }
        });
        btnInicio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent_inicio = new Intent(RegistroMedicos.this, MainActivity.class);
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
        txtEspecialidad = (EditText) findViewById(R.id.txtEspecialidad);
        btnRegistroM = (Button) findViewById(R.id.btnRegistroM);
        btnRegresar = (Button) findViewById(R.id.btnRegresarMedicos);
        btnInicio = (Button) findViewById(R.id.btnInicio);
        obj_base = new Database_admin();

    }
}