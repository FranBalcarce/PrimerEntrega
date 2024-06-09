package gestionReservas;

public class InstalacionDeportiva {
    private String nombre;
    private String tipo;
    private int capacidad;
    private String horario;

    public InstalacionDeportiva(String nombre, String tipo, int capacidad, String horario) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.horario = horario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getHorario() {
        return horario;
    }

    @Override
    public String toString() {
        return "InstalacionDeportiva{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", capacidad=" + capacidad +
                ", horario='" + horario + '\'' +
                '}';
    }
}
