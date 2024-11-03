import java.util.ArrayList;
import java.util.Iterator;

public class Controller {
    private ArrayList<Coche> concesionario = new ArrayList<>();
    private Vista vista;

    public Controller(Vista vista) {
        this.vista = vista;
    }

    public void run() {
        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.leerInt("Ingrese una opción: ");

            switch (opcion) {
                case 1: agregarCoche(); break;
                case 2: eliminarCoche(); break;
                case 3: modificarCoche(); break;
                case 4: listarCoches(); break;
                case 5: vista.mostrarMensaje("¡Hasta luego!"); break;
                default: vista.mostrarMensaje("Opción no válida.");
            }
        } while (opcion != 5);
    }

    private void agregarCoche() {
        String modelo = vista.leerString("Ingrese el modelo del coche: ");
        String marca = vista.leerString("Ingrese la marca del coche: ");
        String matricula = vista.leerString("Ingrese la matrícula del coche: ");
        int anio = vista.leerInt("Ingrese el año del coche: ");
        double precioSinIVA = vista.leerDouble("Ingrese el precio del coche sin IVA: ");
        concesionario.add(new Coche(modelo, marca, matricula, anio, precioSinIVA));
        vista.mostrarMensaje("Coche añadido correctamente.");
    }

    private void eliminarCoche() {
        String matricula = vista.leerString("Ingrese la matrícula del coche a eliminar: ");
        Iterator<Coche> iterator = concesionario.iterator();
        while (iterator.hasNext()) {
            Coche coche = iterator.next();
            if (coche.getMatricula().equals(matricula)) {
                iterator.remove();
                vista.mostrarMensaje("Coche eliminado correctamente.");
                return;
            }
        }
        vista.mostrarMensaje("Coche no encontrado.");
    }

    private void modificarCoche() {
        String matricula = vista.leerString("Ingrese la matrícula del coche a modificar: ");
        Coche cocheAModificar = null;
        for (Coche coche : concesionario) {
            if (coche.getMatricula().equals(matricula)) {
                cocheAModificar = coche;
                break;
            }
        }
        if (cocheAModificar == null) {
            vista.mostrarMensaje("Coche no encontrado.");
            return;
        }
        String modelo = vista.leerString("Ingrese el nuevo modelo del coche: ");
        String marca = vista.leerString("Ingrese la nueva marca del coche: ");
        int anio = vista.leerInt("Ingrese el nuevo año del coche: ");
        double precioSinIVA = vista.leerDouble("Ingrese el nuevo precio del coche sin IVA: ");
        cocheAModificar.setModelo(modelo);
        cocheAModificar.setMarca(marca);
        cocheAModificar.setAnio(anio);
        cocheAModificar.setPrecioSinIVA(precioSinIVA);
        vista.mostrarMensaje("Coche modificado correctamente.");
    }

    private void listarCoches() {
        if (concesionario.isEmpty()) {
            vista.mostrarMensaje("No hay coches en la lista.");
            return;
        }
        for (Coche coche : concesionario) {
            vista.mostrarMensaje(coche.getDescripcion());
        }
    }
}
