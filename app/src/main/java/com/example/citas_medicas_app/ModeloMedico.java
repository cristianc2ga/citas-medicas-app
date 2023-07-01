package com.example.citas_medicas_app;

public class ModeloMedico {
    private String nombres;
    private String apellidos;
    private String documento;
    private String correo;
    private String celular;
    private String especialidad;

    public ModeloMedico(String nombres, String apellidos, String documento, String correo, String celular, String especialidad) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.documento = documento;
        this.correo = correo;
        this.celular = celular;
        this.especialidad = especialidad;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
