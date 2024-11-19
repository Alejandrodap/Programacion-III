public class Factura {
    private String concepto;
    private double descuento;
    private String fecha;
    private double importe;
    private String nif;
    private String nombreCliente;
    private String direccion;
    private double iva;

    public Factura(String concepto, double descuento, String fecha, double importe, String nif, String nombreCliente, String direccion, double iva) {
        this.concepto = concepto;
        this.descuento = descuento;
        this.fecha = fecha;
        this.importe = importe;
        this.nif = nif;
        this.nombreCliente = nombreCliente;
        this.direccion = direccion;
        this.iva = iva;
    }

    public double calcularImporteNeto() {
        return importe * (1 - descuento) * (1 + iva);
    }

    // Getters
    public String getConcepto() {
        return concepto;
    }

    public double getDescuento() {
        return descuento;
    }

    public String getFecha() {
        return fecha;
    }

    public double getImporte() {
        return importe;
    }

    public String getNif() {
        return nif;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getIva() {
        return iva;
    }

    @Override
    public String toString() {
        return concepto + "\t" + descuento + "\t" + fecha + "\t" + importe + "\t" + nif + "\t" + nombreCliente + "\t" + direccion + "\t" + iva;
    }
}