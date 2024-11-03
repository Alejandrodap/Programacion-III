import static com.coti.tools.Esdia.*;

public class V {
    public void menu() {
        System.out.println("\nMenú:");
        System.out.println("1. Leer tabla de ventas");
        System.out.println("2. Leer tabla de precios");
        System.out.println("3. Calcular ingresos totales");
        System.out.println("4. Mostrar resultados");
        System.out.println("q. Salir");
        System.out.print("Seleccione una opción: ");
        }

        public String leerOpcion() {
            return readString("Seleccione una opción: ");
        }

        public int getInt(String prompt) {
            return readInt(prompt);
        }
        public int getInt(String prompt,int min,int max) {
            return readInt(prompt,min,max);
        }
        
        public double getDouble(String prompt) {
            return readDouble(prompt);
        }
        public double getDouble(String prompt,int min,int max) {
            return readDouble(prompt,min,max);
        }

        public void mostrarMensaje(String message) {
            System.out.println(message);
        }
        
        public void mostrarVentas(int[][] ventas) {
            System.out.println("Tabla de Ventas:");
            System.out.printf("%10s %10s %10s\n", "Almacén", "Producto 1", "Producto 2");
            
            for (int i = 0; i < ventas.length; i++) {
                System.out.printf("%10d %10d %10d\n", (i + 1), ventas[i][0], ventas[i][1]);
            }
        }
        
        public void mostrarPrecios(double[] precios) {
            System.out.println("Precios de los productos:");
            System.out.printf("%10s %10s\n", "Producto 1", "Producto 2");
            System.out.printf("%10.2f %10.2f\n", precios[0], precios[1]);
        }
}
