import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int num;
        System.out.println("Introduce un número mayor de 0");
    do {
        num = scan.nextInt();
        if (num<0) {
            System.err.println("Número menor de 0 pruebe otra vez:");
        }
    } while (num < 0);
    

        scan.close();
    }

}
