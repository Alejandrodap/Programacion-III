
import static com.coti.tools.Esdia.*;

import java.util.ArrayList;
import java.util.Iterator;

public class App {


    private static ArrayList<Coche> concesionario = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        int opcion;
        do {
            System.out.println("\n--- MENU CRUD ---");
            System.out.println("1. Agregar Coche");
            System.out.println("2. Eliminar Coche");
            System.out.println("3. Modificar Coche");
            System.out.println("4. Listar Coches");
            System.out.println("5. Salir");
            opcion = readInt("Ingrese una opción: ");
            
            switch (opcion) {
                case 1: agregarCoche(); break;
                case 2: eliminarCoche(); break;
                case 3: modificarCoche(); break;
                case 4: listarCoches(); break;
                case 5: System.out.println("¡Hasta luego!"); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    

    public static void agregarCoche(){
        String modelo = readString("Ingrese en modelo del coche: ");
        String marca =  readString("Ingrese la marca del coche: ");
        String matricula  = readString("Ingrese la matricula del coche: ");
        int anio =  readInt("Ingrese el año del coche: ");
        double precioSinIVA  = readDouble("Ingrese el precio del coche sin IVA: ");
        concesionario.add( new Coche (modelo,marca,matricula,anio,precioSinIVA));
        System.out.println("Coche añadido correctamente.");
    }
    
    public static void eliminarCoche(){
        String matricula  = readString("Ingrese la matricula del coche a eliminar: ");
        Iterator<Coche> iterator=concesionario.iterator();

        while (iterator.hasNext()) {
            Coche coche=iterator.next();
            if (coche.getMatricula().equals(matricula)) {
                iterator.remove();
                System.out.println("Coche eliminado correctamente.");
                return;
            }
        }
        System.out.println("Coche no encontrado.");
    }

    public static void modificarCoche(){
        String matricula = readString("Ingrese la matricula del coche a modificar: ");
        Coche cocheAModificar=null;
        for(Coche  coche:concesionario){
            if(coche.getMatricula().equals(matricula)){
                cocheAModificar=coche;
                break;
            }
        }
        if(cocheAModificar == null){
            System.out.println("Coche no encontrado.");
            return;
        }
        String modelo = readString("Ingrese el nuevo modelo del coche: ");
        String marca = readString("Ingrese la nueva marca del coche: ");
        int anio = readInt("Ingrese el nuevo año del coche: ");
        double precioSinIVA = readDouble("Ingrese el nuevo precio del coche sin IVA:");
        cocheAModificar.setModelo(modelo);
        cocheAModificar.setMarca(marca);
        cocheAModificar.setAnio(anio);
        cocheAModificar.setPrecioSinIVA(precioSinIVA);        
        System.out.println("Coche modificado correctamente.");
    }

    public static void listarCoches(){
        if (concesionario.isEmpty()) {
            System.out.println("No hay coches en la lista");
            return;            
        }
        for(Coche coche:concesionario){
            System.out.println(coche.getDescripcion());
        }

    }
}
