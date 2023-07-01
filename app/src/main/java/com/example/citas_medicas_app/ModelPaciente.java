package com.example.citas_medicas_app;

public class ModelPaciente {
    private String nombres;
    private String apellidos;
    private String documento;
    private String correo;
    private String celular;
    private String fechaNacimiento;

    public ModelPaciente( String nombres, String apellidos, String documento, String correo, String celular, String fechaNacimiento) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.documento = documento;
        this.correo = correo;
        this.celular = celular;
        this.fechaNacimiento = fechaNacimiento;
    }


    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}

