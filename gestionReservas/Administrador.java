package gestionReservas;

public class Administrador extends Usuario {

    public Administrador(String nombre, String email) {
        super(nombre, email);
    }

    public void registrarInstalacion(GestionReservas gestionReservas, InstalacionDeportiva instalacion) {
        gestionReservas.agregarInstalacion(instalacion);
    }
}

