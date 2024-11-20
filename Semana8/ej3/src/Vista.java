import static com.coti.tools.Esdia.*;

import java.util.List;

public class Vista {
    
    public void mostrarMenu() {
        System.out.println("1. Leer fichero TSV");
        System.out.println("2. Mostrar personas tabualdas");
        System.out.println("3. Salir");
    }

    public int solicitarOpcion(){
        return readInt("Elija una opcion");
    }

    public void mostrarPersonas(List<String> personas) {
        System.out.println("Lista de personas en formalto tabular");
        for (String persona : personas) {
            System.out.println(persona);
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}