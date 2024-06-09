package gestionReservas;

import java.util.Date;

public class Reserva {
    private Usuario usuario;
    private InstalacionDeportiva instalacion;
    private Date fechaInicio;
    private Date fechaFin;

    public Reserva(Usuario usuario, InstalacionDeportiva instalacion, Date fechaInicio, Date fechaFin) {
        this.usuario = usuario;
        this.instalacion = instalacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public InstalacionDeportiva getInstalacion() {
        return instalacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "usuario=" + usuario +
                ", instalacion=" + instalacion +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                '}';
    }
}
