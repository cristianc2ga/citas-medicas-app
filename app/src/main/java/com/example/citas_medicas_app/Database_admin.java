package com.example.citas_medicas_app;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Database_admin {


    Connection connect;
    String url = "jdbc:mysql://35.226.16.167:3306/db_app";
    String user = "cristian";
    String pass = "123";

    public boolean connectSQL(){
        try{
            // Enable StrictMode
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            // Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            connect = DriverManager.getConnection(url, user, pass);
            Log.i("MyTag", "Successful Connection");
            return true;
        }
        catch(Exception err){
            Log.i("MyTag", err.toString());
            return false;
        }
    }

    public boolean insertPacientes(String nombres, String apellidos, String documento, String correo, String celular, String fechaNacimiento) {
        String instruction = "INSERT INTO pacientes (nombres, apellidos, documento, correo, celular, fecha_nacimiento) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connect.prepareStatement(instruction);
            statement.setString(1, nombres);
            statement.setString(2, apellidos);
            statement.setString(3, documento);
            statement.setString(4, correo);
            statement.setString(5, celular);
            statement.setString(6, fechaNacimiento);

            int rowsAffected = statement.executeUpdate();
            statement.close();
            connect.close();

            // Verificar si se insertaron filas en la base de datos
            if (rowsAffected > 0) {
                return true; // Registro exitoso
            } else {
                return false; // No se insertaron filas
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Error en la inserción
        }
    }

    public boolean insertMedicos(String nombres, String apellidos, String documento, String correo, String celular, String especialidad) {
        String instruction = "INSERT INTO medicos (nombres, apellidos, documento, correo, celular, especialidad) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connect.prepareStatement(instruction);
            statement.setString(1, nombres);
            statement.setString(2, apellidos);
            statement.setString(3, documento);
            statement.setString(4, correo);
            statement.setString(5, celular);
            statement.setString(6, especialidad);

            int rowsAffected = statement.executeUpdate();
            statement.close();
            connect.close();
            return true;
        } catch (Exception err) {
            return false;
        }
    }
    public ArrayList<String> getPacientes() {
        String instruction = "SELECT * FROM pacientes";
        ArrayList<String> array_pacientes = new ArrayList<>();
        try {
            ResultSet data_table = connect.prepareStatement(instruction).executeQuery();
            while (data_table.next()) {
                int id = data_table.getInt("id");
                String nombres = data_table.getString("nombres");
                String apellidos = data_table.getString("apellidos");
                String documento = data_table.getString("documento");
                String correo = data_table.getString("correo");
                String celular = data_table.getString("celular");
                String fechaNacimiento = data_table.getString("fecha_nacimiento");
                String paciente = id + ";" + nombres + ";" + apellidos + ";" + documento + ";" + correo + ";" + celular + ";" + fechaNacimiento;
                array_pacientes.add(paciente);
            }
            return array_pacientes;
        } catch (Exception err) {
            return null;
        }
    }

    public ArrayList<String> getMedicos() {
        String instruction = "SELECT * FROM medicos";
        ArrayList<String> array_medicos = new ArrayList<>();
        try {
            ResultSet data_table = connect.prepareStatement(instruction).executeQuery();
            while (data_table.next()) {
                int id = data_table.getInt("id");
                String nombres = data_table.getString("nombres");
                String apellidos = data_table.getString("apellidos");
                String documento = data_table.getString("documento");
                String correo = data_table.getString("correo");
                String celular = data_table.getString("celular");
                String especialidad = data_table.getString("especialidad");
                String medico = id + ";" + nombres + ";" + apellidos + ";" + documento + ";" + correo + ";" + celular + ";" + especialidad;
                array_medicos.add(medico);
            }
            return array_medicos;
        } catch (Exception err) {
            return null;
        }
    }

    public boolean insertCita(ModelCita cita) {
        String instruction = "INSERT INTO citas (paciente_id, medico_id, fecha) VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = connect.prepareStatement(instruction);
            statement.setInt(1, cita.getPacienteId());
            statement.setInt(2, cita.getMedicoId());
            statement.setString(3, cita.getFechaCita());

            statement.executeUpdate();

            return true;

        } catch (SQLException err) {
            return false;
        }
    }


    public ArrayList<String> getCitas() {
        String instruction = "SELECT citas.paciente_id, citas.medico_id, citas.fecha, pacientes.nombres AS nombres_paciente, pacientes.apellidos AS apellidos_paciente, pacientes.documento AS documento_paciente, medicos.nombres AS nombres_medico, medicos.apellidos AS apellidos_medico, medicos.especialidad " +
                "FROM citas " +
                "INNER JOIN pacientes ON citas.paciente_id = pacientes.id " +
                "INNER JOIN medicos ON citas.medico_id = medicos.id";
        ArrayList<String> array_citas = new ArrayList<>();
        try {
            ResultSet data_table = connect.prepareStatement(instruction).executeQuery();
            while (data_table.next()) {
                int pacienteId = data_table.getInt("paciente_id");
                int medicoId = data_table.getInt("medico_id");
                String fecha = data_table.getString("fecha");
                String nombresPaciente = data_table.getString("nombres_paciente");
                String apellidosPaciente = data_table.getString("apellidos_paciente");
                String documentoPaciente = data_table.getString("documento_paciente");
                String nombresMedico = data_table.getString("nombres_medico");
                String apellidosMedico = data_table.getString("apellidos_medico");
                String especialidad = data_table.getString("especialidad");

                // Modificar el formato de la cadena de citas
                String cita = pacienteId + ";" + nombresPaciente + ";" + apellidosPaciente + ";" + documentoPaciente + ";" +
                        medicoId + ";" + nombresMedico + ";" + apellidosMedico + ";" + especialidad + ";" + fecha;

                array_citas.add(cita);
            }
            return array_citas;
        } catch (Exception err) {
            err.printStackTrace();
            return null;
        }
    }





}

