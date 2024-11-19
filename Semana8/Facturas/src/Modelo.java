import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

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


}