
import static com.coti.tools.Esdia.*;

public class App {


    private static final int MAX_SIZE = 5;
    private static Coche[] concesionario = new Coche[MAX_SIZE];
    private static int  numCoche = 0;


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
        if (numCoche>=MAX_SIZE) {
            System.out.println("Array de coches está lleno.");
            return;
        }
        String modelo = readString("Ingrese en modelo del coche: ");
        String marca =  readString("Ingrese la marca del coche: ");
        String matricula  = readString("Ingrese la matricula del coche: ");
        int anio =  readInt("Ingrese el año del coche: ");
        double precioSinIVA  = readDouble("Ingrese el precio del coche sin IVA: ");
        concesionario[numCoche++]= new Coche (modelo,marca,matricula,anio,precioSinIVA);
        System.out.println("Coche añadido correctamente.");
    }
    
    public static void eliminarCoche(){
        String matricula  = readString("Ingrese la matricula del coche a eliminar: ");
        for (int i = 0; i < numCoche; i++) {
            if (concesionario[i].getMatricula().equals(matricula)) {

                for (int j=i;  j < numCoche-1; j++) 
                    concesionario[j]=concesionario[j+1];
                numCoche--;
                System.out.println("Coche eliminado correctamente.");
                return;
            }
        }
        System.out.println("Coche no encontrado.");
    }

    public static void modificarCoche(){
        String matricula = readString("Ingrese la matricula del coche a modificar: ");
        for (int i =0; i<numCoche;i++){
            if (concesionario[i].getMatricula().equals(matricula)) {
                String modelo = readString("Ingrese el nuevo modelo del coche: ");
                String marca = readString("Ingrese la nueva marca del coche: ");
                int anio = readInt("Ingrese el nuevo año del coche: ");
                double precioSinIVA = readDouble("Ingrese el nuevo precio del coche sin IVA:");
                concesionario[i].setModelo(modelo);
                concesionario[i].setMarca(marca);
                concesionario[i].setAnio(anio);
                concesionario[i].setPrecioSinIVA(precioSinIVA);        
                System.out.println("Coche modificado correctamente.");
                return;
            }
        }
        System.out.println("Coche no encontrado");
    }

    public static void listarCoches(){
        if (numCoche==0) {
            System.out.println("No hay coches en el array");
            return;
        }
        for(int i=0;i<numCoche;i++){
            System.out.println(concesionario[i].getDescripcion());
        }

    }




}
