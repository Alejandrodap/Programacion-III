import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.coti.tools.OpMat;
import com.coti.tools.Rutas;

public class Modelo {
    private List<Factura> facturas;

    public Modelo() {
        this.facturas = new ArrayList<>();
    }

    public void agregarFactura(Factura factura) {
        facturas.add(factura);
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public List<String> obtenerClientesConFacturasMayores(double valorMinimo) {
        List<String> clientes = new ArrayList<>();
        for (Factura factura : facturas) {
            if (factura.calcularImporteNeto() > valorMinimo) {
                if (!clientes.contains(factura.getNombreCliente())) {
                    clientes.add(factura.getNombreCliente());
                }
            }
        }
        return clientes;
    }

    public void leerFacturas(){
        Path archivo=Rutas.pathToFileOnDesktop("facturas.tsv");
        List<String> lineas=null;
        try{
            lineas=Files.readAllLines(archivo);
            for(String linea:lineas){
                Factura f=getFacturaTexto(linea,"\t");
                facturas.add(f);
            }
        }catch(IOException ex){
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public static Factura getFacturaTexto(String linea, String separador) {
        String[] info = linea.split(separador);
        
        if (info.length !=8) {
            System.out.println("ERROR: linea invalida");            
            return null;
        }
    
        String concepto = info[0];
        double descuento = Double.parseDouble(info[1]);
        String fecha = info[2];
        double importe = Double.parseDouble(info[3]);
        String nif = info[4];
        String nombreCliente = info[5];
        String direccion = info[6];
        double iva = Double.parseDouble(info[7]);
    
        // Crear y devolver la factura
        return new Factura(concepto, descuento, fecha, importe, nif, nombreCliente, direccion, iva);
    }

public void exportarAHtml() {
        StringBuilder html = new StringBuilder();
        html.append("<html><head><title>Facturas</title></head><body>");
        html.append("<h1>Listado de Facturas</h1>");
        html.append("<table border='1'><tr><th>Concepto</th><th>Descuento</th><th>Fecha</th><th>Importe</th><th>NIF</th><th>Cliente</th><th>Dirección</th><th>IVA</th></tr>");

        for (Factura factura : facturas) {
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

        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());

        }
    }

    public void exportarACsv() {
        String[][] datosFacturas = new String[facturas.size() ][8]; 
    
        int i = 0;
        for (Factura factura : facturas) {
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

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}