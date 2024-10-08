public class Fruta {
    private String nombre;
    private double precioPorKg; // Precio sin IVA
    private double cantidadKg;
    private static final double IVA = 0.21; // IVA fijo al 21%

    // Constructor
    public Fruta(String nombre, double precioPorKg) {
        this.nombre = nombre;
        this.precioPorKg = precioPorKg;
        this.cantidadKg = 0;
    }

    // Métodos para establecer y obtener valores
    public String getNombre() {
        return nombre;
    }

    public void setCantidadKg(double cantidadKg) {
        this.cantidadKg = cantidadKg;
    }

    public double getCantidadKg() {
        return cantidadKg;
    }

    // Método para obtener el precio por kg con IVA
    public double getPrecioPorKgConIVA() {
        return precioPorKg * (1 + IVA);
    }

    // Método para calcular el total con IVA
    public double calcularPrecioTotal() {
        return cantidadKg * getPrecioPorKgConIVA();
    }
}
