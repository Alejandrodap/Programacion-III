import java.util.Scanner;

public class Fruteria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int NUM_FRUTAS = 2;
        Fruta[] frutas = new Fruta[NUM_FRUTAS];

        System.out.println("Introduce el precio por kg de las peras (sin IVA): ");
        double precio = scanner.nextDouble();
        frutas[0] = new Fruta("Peras", precio);
        
        System.out.println("Introduce el precio por kg de las manzanas (sin IVA): ");
        precio = scanner.nextDouble();
        frutas[1] = new Fruta("Manzanas", precio);
        int cliente = 0;
        boolean continuar = true;

        while (continuar) {
            cliente++;            
            System.out.println("\n--- Cliente #" + cliente + " ---");

            for (Fruta fruta : frutas) {
                System.out.println("Introduce la cantidad de " + fruta.getNombre() + " en kg: ");
                fruta.setCantidadKg(scanner.nextDouble());
            }
            double totalCompra = 0;
            System.out.println("\n--- Factura para el cliente #" + cliente + " ---");
            System.out.printf("%-10s %-15s %-15s %-15s\n", "Fruta", "Cantidad (kg)", "Precio/kg con IVA", "Precio total");
            for (Fruta fruta : frutas) {
                double totalFruta = fruta.calcularPrecioTotal();
                totalCompra += totalFruta;
                System.out.printf("%-10s %-15.2f %-15.2f %-15.2f\n", fruta.getNombre(), fruta.getCantidadKg(), fruta.getPrecioPorKgConIVA(), totalFruta);
            }
            System.out.printf("\nTotal de la compra: %.2f €\n", totalCompra);

            System.out.println("\n¿Otro? (s/n): ");
            scanner.nextLine();
            String respuesta = scanner.nextLine();
            
            if (!respuesta.equalsIgnoreCase("s")) {
                continuar = false;
            }
        }
        scanner.close();
    }
}
