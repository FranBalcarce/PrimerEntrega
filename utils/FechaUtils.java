package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class FechaUtils {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static LocalDate leerFecha(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String input = scanner.nextLine();
            try {
                return LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha no válido. Por favor, use el formato yyyy-mm-dd.");
            }
        }
    }
}


