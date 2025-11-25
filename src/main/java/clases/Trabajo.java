package clases;

import java.util.Date;

public class Trabajo extends Solicitud{
    private String entidadContratadora;
    private String tipoTrabajo;
    private int tarifaHoras;
    private int horasLaborables;

    public Trabajo(String codigo, String nombre, String pasaporte, Date fechaViaje, int semanas, String motivo, String entidadContratadora, String tipoTrabajo, int tarifaHoras, int horasLaborables) {
        super(codigo, nombre, pasaporte, fechaViaje, semanas, motivo);
        this.entidadContratadora = entidadContratadora;
        this.tipoTrabajo = tipoTrabajo;
        this.tarifaHoras = tarifaHoras;
        this.horasLaborables = horasLaborables;
    }

    public String getEntidadContratadora() {
        return entidadContratadora;
    }

    public void setEntidadContratadora(String entidadContratadora) {
        this.entidadContratadora = entidadContratadora;
    }

    public String getTipoTrabajo() {
        return tipoTrabajo;
    }

    public void setTipoTrabajo(String tipoTrabajo) {
        this.tipoTrabajo = tipoTrabajo;
    }

    public int getTarifaHoras() {
        return tarifaHoras;
    }

    public void setTarifaHoras(int tarifaHoras) {
        this.tarifaHoras = tarifaHoras;
    }

    public int getHorasLaborables() {
        return horasLaborables;
    }

    public void setHorasLaborables(int horasLaborables) {
        this.horasLaborables = horasLaborables;
    }

    @Override
    public double pagoSolicitud() {
        return 60 + ((this.getSemanas() * 0.05) * 60);
    }
}
