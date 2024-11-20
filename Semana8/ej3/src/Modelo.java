import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.coti.tools.Rutas;

public class Modelo {
    private List<Persona> personas;

    public Modelo() {
        this.personas = new ArrayList<>();
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public List<String> getPersonaTabulada(){
        List<String> texto= new ArrayList<>();
        for(Persona persona: personas){
            texto.add(persona.toString());
        }
        return texto;
    }

    public void leerPersonas(){
        String separador="\t";
        Path ruta = Rutas.pathToFileOnDesktop("personas.tsv");
        List<String> lineas=null;
        try{
            lineas=Files.readAllLines(ruta);
            for(String linea : lineas){
                personas.add(getPersonaTexto(linea, separador));
            }
        }catch(IOException e){
            System.out.println("ERROR: " + e.getMessage());
        } 
    }

    public static Persona getPersonaTexto(String linea, String separador) {
        String [] info=linea.split(separador);
        int numero=Integer.valueOf(info[1]);
        double peso=Double.valueOf(info[2]);
    return new Persona(info[0],numero ,peso);
    }


}