package com.example.citas_medicas_app;

public class ModelCita {
    private int pacienteId;
    private int medicoId;
    private String fechaCita;

    public ModelCita(int pacienteId, int medicoId, String fechaCita) {
        this.pacienteId = pacienteId;
        this.medicoId = medicoId;
        this.fechaCita = fechaCita;
    }

    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }

    public int getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(int medicoId) {
        this.medicoId = medicoId;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }
}

