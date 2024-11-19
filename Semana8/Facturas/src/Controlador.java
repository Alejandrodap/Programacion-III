import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.coti.tools.OpMat;
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
                    exportarAHtml();
                    break;
                case 4:
                    exportarACsv();
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void exportarAHtml() {
        StringBuilder html = new StringBuilder();
        html.append("<html><head><title>Facturas</title></head><body>");
        html.append("<h1>Listado de Facturas</h1>");
        html.append("<table border='1'><tr><th>Concepto</th><th>Descuento</th><th>Fecha</th><th>Importe</th><th>NIF</th><th>Cliente</th><th>Dirección</th><th>IVA</th></tr>");

        for (Factura factura : modelo.getFacturas()) {
            html.append("<tr>")
                .append("<td>").append(factura.getConcepto()).append("</td>")
                .append("<td>").append(factura.getDescuento()).append("</td>")
                .append("<td>").append(factura.getFecha()).append("</td>")
                .append("<td>").append(factura.getImporte()).append("</td>")
                .append("<td>").append(factura.getNif()).append("</td>")
                .append("<td>").append(factura.getNombreCliente()).append("</td>")
                .append("<td>").append(factura.getDireccion()).append("</td>")
                .append("<td>").append(factura.getIva()).append("</td>")
                .append("</tr>");
        }

        html.append("</table></body></html>");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("facturas.html"))) {
            writer.write(html.toString());
            vista.mostrarMensaje("Facturas exportadas a facturas.html");
        } catch (IOException e) {
            vista.mostrarMensaje("Error al exportar a HTML: " + e.getMessage());
        }
    }

    private void exportarACsv() {
        String[][] datosFacturas = new String[modelo.getFacturas().size() ][8]; 
    
        int i = 0;
        for (Factura factura : modelo.getFacturas()) {
            datosFacturas[i] = new String[]{
                factura.getConcepto(),
                String.valueOf(factura.getDescuento()),
                factura.getFecha(),
                String.valueOf(factura.getImporte()),
                factura.getNif(),
                factura.getNombreCliente(),
                factura.getDireccion(),
                String.valueOf(factura.getIva())
            };
            i++;
        }

        File archivoCsv = new File("facturas.csv");
        String separador = ","; 
    
        try {
            OpMat.exportToDisk(datosFacturas, archivoCsv, separador);
            vista.mostrarMensaje("Facturas exportadas a facturas.csv");
        } catch (Exception e) {
            vista.mostrarMensaje("Error al exportar a CSV: " + e.getMessage());
        }
    }
}