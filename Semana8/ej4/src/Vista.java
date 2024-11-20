import static com.coti.tools.Esdia.*;

import java.util.List;

public class Vista {
    
    public void mostrarMenu() {
        System.out.println("1. Crear datos aleatorios");
        System.out.println("2. Mostrar alumnos tabualdas");
        System.out.println("3. Exportar datos personales a csv");
        System.out.println("4. Exportar direcciones a csv");
        System.out.println("5. Salir");
    }

    public int solicitarOpcion(){
        return readInt("Elija una opcion");
    }

    public void mostrarPersonas(List<String> datosDeAlumno) {
        System.out.println("Lista de datos de alumnos en formato tabular");
        for (String alumno : datosDeAlumno) {
            System.out.println(alumno);
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}