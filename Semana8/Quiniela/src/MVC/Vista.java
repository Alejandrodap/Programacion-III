package MVC;

import java.util.List;

import static com.coti.tools.Esdia.*;

public class Vista {

    public void mostrarMenu() {
        System.out.println("1. Solicitar partidos");
        System.out.println("2. Mostrar resultados");
        System.out.println("3. Mostrar quiniela");
        System.out.println("4. Salir");
    }

    public int solicitarOpcion() {
        return readInt("Seleccione una opción: ");
    }

    public Partido solicitarPartido() {
        String equipo1 = readString("Ingrese el nombre del equipo 1: ");
        String equipo2 = readString("Ingrese el nombre del equipo 2: ");
        return new Partido(equipo1, equipo2);
    }

    public void mostrarResultados(List<Partido> partidos) {
        for (Partido partido : partidos) {
            System.out.println(partido.getEquipo1() + " vs " + partido.getEquipo2() + " - " + partido.getResultado());
        }
    }

    public void mostrarQuiniela(List<Partido> partidos) {
        System.out.println("Quiniela:");
        for (Partido partido : partidos) {
            System.out.println(partido.getEquipo1() + " vs " + partido.getEquipo2());
        }
    }

    public void lecturaDeArchivo(String mensaje ){
        System.out.println(mensaje);
    }
}
