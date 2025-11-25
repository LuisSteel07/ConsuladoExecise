package clases;

import enums.Hospedaje;

import java.util.Date;

public class Turista extends Solicitud{
    private Hospedaje hospedaje;

    public Turista(String codigo, String nombre, String pasaporte, Date fechaViaje, int semanas, String motivo, Hospedaje hospedaje) {
        super(codigo, nombre, pasaporte, fechaViaje, semanas, motivo);
        this.hospedaje = hospedaje;
    }

    public Hospedaje getHospedaje() {
        return hospedaje;
    }

    public void setHospedaje(Hospedaje hospedaje) {
        this.hospedaje = hospedaje;
    }

    @Override
    public double pagoSolicitud() {
        double meses = this.getSemanas() % 4;
        return 60 + ((meses * 0.05) * 60);
    }
}
