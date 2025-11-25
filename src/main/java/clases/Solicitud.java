package clases;

import java.util.Date;

public abstract class Solicitud {
    private String codigo;
    private String nombre;
    private String pasaporte;
    private Date fechaViaje;
    private int semanas;
    private String motivo;

    public Solicitud(String codigo, String nombre, String pasaporte, Date fechaViaje, int semanas, String motivo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.pasaporte = pasaporte;
        this.fechaViaje = fechaViaje;
        this.semanas = semanas;
        this.motivo = motivo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    public Date getFechaViaje() {
        return fechaViaje;
    }

    public void setFechaViaje(Date fechaViaje) {
        this.fechaViaje = fechaViaje;
    }

    public int getSemanas() {
        return semanas;
    }

    public void setSemanas(int semanas) {
        this.semanas = semanas;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public double pagoSolicitud(){
        return 60;
    }
}
