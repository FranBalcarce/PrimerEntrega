package gestionReservas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import exception.ReservaException;

public class GestionReservas {
    private List<InstalacionDeportiva> instalaciones = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();

    public void agregarInstalacion(InstalacionDeportiva instalacion) {
        instalaciones.add(instalacion);
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equalsIgnoreCase(email)) {
                return usuario;
            }
        }
        return null;
    }

    public InstalacionDeportiva buscarInstalacionPorNombre(String nombre) {
        for (InstalacionDeportiva instalacion : instalaciones) {
            if (instalacion.getNombre().equalsIgnoreCase(nombre)) {
                return instalacion;
            }
        }
        return null;
    }

    public void realizarReserva(Usuario usuario, InstalacionDeportiva instalacion, Date fechaInicio, Date fechaFin) throws ReservaException {
        for (Reserva reserva : reservas) {
            if (reserva.getInstalacion().equals(instalacion) &&
                    reserva.getFechaInicio().compareTo(fechaFin) <= 0 &&
                    reserva.getFechaFin().compareTo(fechaInicio) >= 0) {
                throw new ReservaException("La instalación no está disponible en las fechas solicitadas.");
            }
        }
        Reserva nuevaReserva = new Reserva(usuario, instalacion, fechaInicio, fechaFin);
        reservas.add(nuevaReserva);
    }

    public void cancelarReserva(Usuario usuario, InstalacionDeportiva instalacion, Date fechaInicio, Date fechaFin) throws ReservaException {
        Reserva reservaACancelar = null;
        for (Reserva reserva : reservas) {
            if (reserva.getUsuario().equals(usuario) &&
                reserva.getInstalacion().equals(instalacion) &&
                reserva.getFechaInicio().equals(fechaInicio) &&
                reserva.getFechaFin().equals(fechaFin)) {
                reservaACancelar = reserva;
                break;
            }
        }
        if (reservaACancelar != null) {
            reservas.remove(reservaACancelar);
        } else {
            throw new ReservaException("No se encontró una reserva que coincida con los criterios proporcionados.");
        }
    }

    public List<Reserva> listarReservas() {
        return reservas;
    }

    public List<InstalacionDeportiva> listarInstalaciones() {
        return instalaciones;
    }
}
