
import java.util.Scanner;
public class CalcularEdad {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Ingrese su año de nacimiento:");
        int nacimiento=scan.nextInt();
        System.out.println("Ingrese el año actual: ");
        int  actual=scan.nextInt();
        int edad=actual-nacimiento;
        System.out.println("Su edad es "+edad+" años");
        scan.close();
    }
}