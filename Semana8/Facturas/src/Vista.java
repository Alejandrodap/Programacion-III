import static com.coti.tools.Esdia.*;

import java.util.List;

public class Vista {
    
    public void mostrarMenu() {
        System.out.println("1. Proporcionar valor mínimo de factura");
        System.out.println("2. Mostrar listado total de facturas");
        System.out.println("3. Exportar a HTML");
        System.out.println("4. Exportar a CSV");
        System.out.println("5. Salir");
    }

    public int solicitarOpcion(){
        return readInt("Elija una opcion");
    }

    public double solicitarValorMinimo() {
        return readDouble("Ingrese el valor mínimo de factura: ");
    }

    public void mostrarClientes(List<String> clientes) {
        System.out.println("Clientes con facturas mayores al valor proporcionado:");
        for (String cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public void mostrarFacturas(List<Factura> facturas) {
        System.out.println("Listado de facturas:");
        for (Factura factura : facturas) {
            System.out.println(factura);
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}