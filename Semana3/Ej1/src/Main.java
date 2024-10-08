import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);

        Person[] gente = new Person[7];
        for (int i = 0; i < gente.length; i++) {
            gente[i] = new Person();
            System.out.println("Introduce el nombre: ");
            gente[i].setNombre(s.nextLine());

            System.out.println("Introduce la altura: ");
            float altura = Float.parseFloat(s.nextLine()); // leer como cadena y luego convertir
            gente[i].setAltura(altura);

            System.out.println("Introduce el peso: ");
            float peso = Float.parseFloat(s.nextLine()); // leer como cadena y luego convertir
            gente[i].setPeso(peso);
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
