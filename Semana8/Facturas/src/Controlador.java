
import java.util.List;

public class Controlador {
    private Modelo modelo;
    private Vista vista;

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        boolean continuar = true;
        modelo.leerFacturas();
        while (continuar) {
            vista.mostrarMenu();
            int opcion = vista.solicitarOpcion();
            switch (opcion) {
                case 1:
                    double valorMinimo = vista.solicitarValorMinimo();
                    List<String> clientes = modelo.obtenerClientesConFacturasMayores(valorMinimo);
                    vista.mostrarClientes(clientes);
                    break;
                case 2:
                    vista.mostrarFacturas(modelo.getFacturas());
                    break;
                case 3:
                    modelo.exportarAHtml();
                    break;
                case 4:
                    modelo.exportarACsv();
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Intente de nuevo.");
            }
        }
    }

    
}