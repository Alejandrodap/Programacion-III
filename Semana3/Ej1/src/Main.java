import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);

        Person[] gente = new Person[3];
        for (int i = 0; i < gente.length; i++) {
            gente[i] = new Person();
            System.out.println("Introduce el nombre: ");
            gente[i].setNombre(s.nextLine());
            System.out.println("Introduce la altura: ");
            gente[i].setAltura(s.nextFloat());
            s.nextLine(); // Consumir la línea restante
            System.out.println("Introduce el peso: ");
            gente[i].setPeso(s.nextFloat());
            s.nextLine(); // Consumir la línea restante
        }

        Person alto = gente[0];
        Person pesado = gente[0];

        if (gente[1].getAltura() > alto.getAltura()) {
            alto = gente[1];
        }
        if (gente[2].getAltura() > alto.getAltura()) {
            alto = gente[2];
        }

        if (gente[1].getPeso() > pesado.getPeso()) {
            pesado = gente[1];
        }
        if (gente[2].getPeso() > pesado.getPeso()) {
            pesado = gente[2];
        }

        System.out.println("El más alto es: " + alto.getNombre());
        System.out.println("El más pesado es: " + pesado.getNombre());

        System.out.println("El IMC de " + gente[0].getNombre() + " es " + gente[0].calcularIMC());
        System.out.println("El IMC de " + gente[1].getNombre() + " es " + gente[1].calcularIMC());
        System.out.println("El IMC de " + gente[2].getNombre() + " es " + gente[2].calcularIMC());

        s.close();
    }
}
