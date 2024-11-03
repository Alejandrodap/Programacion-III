import java.util.Scanner;

public class Vista {
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\n--- MENU CRUD ---");
        System.out.println("1. Agregar Coche");
        System.out.println("2. Eliminar Coche");
        System.out.println("3. Modificar Coche");
        System.out.println("4. Listar Coches");
        System.out.println("5. Salir");
    }

    public int leerInt(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    public double leerDouble(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextDouble();
    }

    public String leerString(String mensaje) {
        System.out.print(mensaje);
        return scanner.next();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
