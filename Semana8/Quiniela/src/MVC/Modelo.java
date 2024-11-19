package MVC;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.coti.tools.Rutas;

public class Modelo {
    private ArrayList<Partido> partidos;

    public Modelo(){
        this.partidos = new ArrayList<Partido>();
    }

    public void agregarPartido(Partido partido){
        this.partidos.add(partido);
    }

    public void leerPartidos(){
        Path archivo =Rutas.pathToFileOnDesktop("equipos.txt") ;
        List<String> lineas =null;
        try{
            if (!Files.exists(archivo)) {
                System.out.println("El archivo no existe en la ruta especificada.");
                return;
            }
            lineas=Files.readAllLines(archivo);
            System.out.println(lineas);
            for(String linea:lineas){
                Partido p = getPartidoTexto(linea,"-");
                partidos.add(p);
            }
        }catch(IOException ex){
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public static Partido getPartidoTexto(String linea, String separador){

        String[] equipos=linea.split(separador);
        if (equipos.length !=2) {
            System.out.println("ERROR: linea invalida");            
            return null;
        }
        try{ 
            Partido p =new Partido(equipos[0], equipos[1]);
            return p;
        }catch(Exception e){
            System.err.println("ERROR: "+e);
            return null;
        }
    }

    public ArrayList<Partido> mostrarPartidos(){
        return partidos;
    }
}
