import java.util.*;

public class Modelo {
    private List<DatosDeAlumno> dalumnos;

    // Constructor de la clase Modelo
    public Modelo() {
        this.dalumnos = new ArrayList<>();
    }

    // Método para crear 20 alumnos con datos aleatorios
    public void crearRandom() {
        for (int i = 0; i < 20; i++) {
            // Crear un nuevo alumno con datos aleatorios
            DatosPersonales datosPersonales = DatosPersonales.generarDatosPersonalesAleatorios();
            Direccion direccion = Direccion.generarDireccionAleatoria();
            
            // Crear el objeto DatosDeAlumno y agregarlo a la lista
            dalumnos.add(new DatosDeAlumno(direccion, datosPersonales));
        }
    }

    // Método para mostrar los alumnos
    public void mostrarAlumnos() {
        for (DatosDeAlumno alumno : dalumnos) {
            System.out.println(alumno);
        }
    }



}
