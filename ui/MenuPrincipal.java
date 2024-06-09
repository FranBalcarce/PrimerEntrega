package ui;

import gestionReservas.*;
import exception.ReservaException;
import utils.FechaUtils;

import java.time.LocalDate;
import java.util.Scanner;

public class MenuPrincipal {
    private GestionReservas gestionReservas = new GestionReservas();
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("1. Registrar instalación deportiva");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Realizar reserva");
            System.out.println("4. Listar instalaciones");
            System.out.println("5. Listar reservas");
            System.out.println("6. Cancelar reserva");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (opcion) {
                case 1:
                    registrarInstalacion();
                    break;
                case 2:
                    registrarUsuario();
                    break;
                case 3:
                    realizarReserva();
                    break;
                case 4:
                    listarInstalaciones();
                    break;
                case 5:
                    listarReservas();
                    break;
                case 6:
                    cancelarReserva();
                    break;
                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 7);
    }

    private void registrarInstalacion() {
        System.out.print("Nombre de la instalación: ");
        String nombre = scanner.nextLine();
        System.out.print("Tipo de instalación: ");
        String tipo = scanner.nextLine();
        System.out.print("Capacidad: ");
        int capacidad = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Horario de funcionamiento: ");
        String horario = scanner.nextLine();

        InstalacionDeportiva instalacion = new InstalacionDeportiva(nombre, tipo, capacidad, horario);
        gestionReservas.agregarInstalacion(instalacion);
        System.out.println("Instalación registrada con éxito.");
    }

    private void registrarUsuario() {
        System.out.print("Nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Email del usuario: ");
        String email = scanner.nextLine();

        Usuario usuario = new Usuario(nombre, email);
        gestionReservas.agregarUsuario(usuario);
        System.out.println("Usuario registrado con éxito.");
    }

    private void realizarReserva() {
        try {
            System.out.print("Email del usuario: ");
            String emailUsuario = scanner.nextLine();
            Usuario usuario = gestionReservas.buscarUsuarioPorEmail(emailUsuario);
            if (usuario == null) {
                System.out.println("Usuario no encontrado.");
                return;
            }

            System.out.print("Nombre de la instalación: ");
            String nombreInstalacion = scanner.nextLine();
            InstalacionDeportiva instalacion = gestionReservas.buscarInstalacionPorNombre(nombreInstalacion);
            if (instalacion == null) {
                System.out.println("Instalación no encontrada.");
                return;
            }

            LocalDate fechaInicio = FechaUtils.leerFecha(scanner, "Fecha de inicio (yyyy-mm-dd): ");
            LocalDate fechaFin = FechaUtils.leerFecha(scanner, "Fecha de fin (yyyy-mm-dd): ");

            gestionReservas.realizarReserva(usuario, instalacion, java.sql.Date.valueOf(fechaInicio), java.sql.Date.valueOf(fechaFin));
            System.out.println("Reserva realizada con éxito.");
        } catch (ReservaException e) {
            System.out.println("Error al realizar la reserva: " + e.getMessage());
        }
    }

    private void cancelarReserva() {
        try {
            System.out.print("Email del usuario: ");
            String emailUsuario = scanner.nextLine();
            Usuario usuario = gestionReservas.buscarUsuarioPorEmail(emailUsuario);
            if (usuario == null) {
                System.out.println("Usuario no encontrado.");
                return;
            }

            System.out.print("Nombre de la instalación: ");
            String nombreInstalacion = scanner.nextLine();
            InstalacionDeportiva instalacion = gestionReservas.buscarInstalacionPorNombre(nombreInstalacion);
            if (instalacion == null) {
                System.out.println("Instalación no encontrada.");
                return;
            }

            LocalDate fechaInicio = FechaUtils.leerFecha(scanner, "Fecha de inicio (yyyy-mm-dd): ");
            LocalDate fechaFin = FechaUtils.leerFecha(scanner, "Fecha de fin (yyyy-mm-dd): ");

            gestionReservas.cancelarReserva(usuario, instalacion, java.sql.Date.valueOf(fechaInicio), java.sql.Date.valueOf(fechaFin));
            System.out.println("Reserva cancelada con éxito.");
        } catch (ReservaException e) {
            System.out.println("Error al cancelar la reserva: " + e.getMessage());
        }
    }

    private void listarInstalaciones() {
        for (InstalacionDeportiva instalacion : gestionReservas.listarInstalaciones()) {
            System.out.println(instalacion);
        }
    }

    private void listarReservas() {
        for (Reserva reserva : gestionReservas.listarReservas()) {
            System.out.println(reserva);
        }
    }
}
