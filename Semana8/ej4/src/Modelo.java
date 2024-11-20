import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
            System.out.println(alumno.toString());
        }
    }

    public void exportarDireccionesCSV(){
        String ruta=System.getProperty("user.dir")+File.separator+"Semana8"+ File.separator+"ej4"+File.separator+"direcciones.txt";
        File archivo=new File(ruta);
        try{PrintWriter writer= new PrintWriter (archivo);
            for(DatosDeAlumno alumno : dalumnos){
                Direccion direccion=alumno.getDireccion();
                writer.println(direccion.toCSV());
            }        
            writer.close();
        }catch(IOException e){
            System.out.println("ERROR: " + e.getMessage());  
        }
    }

    public void exportarDatosAlumnoCSV(){
        String ruta=System.getProperty("user.dir")+File.separator+"Semana8"+ File.separator+"ej4"+File.separator+"datosAlumno.txt";
        File archivo=new File(ruta);
        try{PrintWriter writer= new PrintWriter (archivo);
            for(DatosDeAlumno alumno : dalumnos){
                DatosPersonales datosPersonales=alumno.getDatosAlmuno();
                writer.println(datosPersonales.toCSV());
            }        
            writer.close();
        }catch(IOException e){
            System.out.println("ERROR: " + e.getMessage());  
        }
    }


}
