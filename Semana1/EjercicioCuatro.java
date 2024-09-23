import java.util.Scanner;

public class EjercicioCuatro {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1;
        int num2;
        int num3;

        System.out.println("Ingrese el primer número");
        num1 = scan.nextInt();

        System.out.println("Ingrese el segundo número");
        num2 = scan.nextInt();

        System.out.println("Ingrese el tercer número");
        num3 = scan.nextInt();

        if (num1 > num2 && num1 > num3) {
            System.out.println("El mayor es el 1º y su valor es " + num1);
        } else if (num2 > num1 && num2 > num3) {
            System.out.println("El mayor es el 2º y su valor es " + num2);
        } else if (num3 > num1 && num3 > num2) {
            System.out.println("El mayor es el 3º y su valor es " + num3);
        } else if (num1 == num2 && num1 == num3) {
            System.out.println("Los tres números son iguales y su valor es " + num1);
        } else if (num1 == num2) {
            System.out.println("El 1º y 2º son iguales y son mayores que el 3º, su valor es " + num1);
        } else if (num1 == num3) {
            System.out.println("El 1º y 3º son iguales y son mayores que el 2º, su valor es " + num1);
        } else if (num2 == num3) {
            System.out.println("El 2º y 3º son iguales y son mayores que el 1º, su valor es " + num2);
        }

        scan.close();
    }
}
