
import java.io.Console;

public class Ej2 {
    public static void main(String[] args) {
        Console console=System.console();
        System.out.println("Ingrese su año de nacimiento:");
        String texto=console.readLine();
        int nacimiento=Integer.parseInt(texto);
        System.out.println("Ingrese el año actual: ");
        texto=console.readLine();
        int actual=Integer.parseInt(texto);
        int  edad=actual-nacimiento;
        System.out.println("Su edad es "+edad+" años");
    }
}