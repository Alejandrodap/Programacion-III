import com.coti.tools.Esdia;
import clases.*;

public class App {
    public static void main(String[] args) {
        int opcion = 0;
        float ritmoLectura = 1;
        Almacen almacen = new Almacen();
        
        do {
            System.out.println("|----------------------------------------------|");
            System.out.println("| GESTIÓN DE LIBROS - MENÚ CRUD                |");
            System.out.println("|----------------------------------------------|");
            System.out.println("1) Crear nuevo almacén de libros");
            System.out.println("2) Establecer ritmo de lectura (páginas por minuto)");
            System.out.println("3) Añadir un nuevo libro al almacén");
            System.out.println("4) Mostrar información de todos los libros");
            System.out.println("5) Actualizar información de un libro");
            System.out.println("6) Eliminar un libro del almacén");
            System.out.println("7) Salir (se borrará toda la información)");
            System.out.println("|----------------------------------------------|");
            opcion = Esdia.readInt("Seleccione una opción ", 1, 7);

            switch (opcion) {
                case 1:
                    almacen.crearAlmacen();
                    break;
                case 2:
                    ritmoLectura = Esdia.readFloat("Estableciendo ritmo de lectura a: ");
                    break;
                case 3:
                    System.out.println("Añadiendo nuevo libro...");
                    almacen.añadirLibro();
                    break;
                case 4:
                    almacen.mostrarLibros(ritmoLectura);
                    break;
                case 5:
                    System.out.println("Actualizando información de un libro...");
                    almacen.actualizarLibro(); // Método a implementar en la clase Almacen
                    break;
                case 6:
                    System.out.println("Eliminando un libro del almacén...");
                    almacen.eliminarLibro(); // Método a implementar en la clase Almacen
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 7);
    }
}
