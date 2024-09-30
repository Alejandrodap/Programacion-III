import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner s =new Scanner(System.in);
        String nombre;
        float peso,altura;
        Person p1=new Person ();
        System.out.println("Introduce el nombre: ");
        p1.setNombre(s.nextLine());
        System.out.println("Introduce la altura: ");
        p1.setAltura(s.nextFloat());
        System.out.println("Introduce el peso: ");
        p1.setPeso(s.nextFloat());

        Person p2=new Person();
        System.out.println("Introduce el nombre: ");
        p2.setNombre(s.nextLine());
        System.out.println("Introduce la altura: ");
        p2.setAltura(s.nextFloat());
        System.out.println("Introduce el peso: ");
        p2.setPeso(s.nextFloat());
        
        nombre="Juan";
        altura=(float) 1.8;
        peso=(float) 70;
        Person p3=new Person(nombre,altura,peso);

        Person alto = p1;
        Person pesado = p1;

        if (p2.getAltura() > alto.getAltura()) {
            alto = p2;
        }
        if (p3.getAltura() > alto.getAltura()) {
            alto = p3;
        }

        if (p2.getPeso() > pesado.getPeso()) {
            pesado = p2;
        }
        if (p3.getPeso() > pesado.getPeso()) {
            pesado = p3;
        }
        System.out.println("El mas alto es:"+alto.getNombre());
        System.out.println("El mas pesado es:"+pesado.getNombre());

        System.out.println("El IMC de "+p1.getNombre()+" es "+p1.calcularIMC());
        System.out.println("El IMC de "+p2.getNombre()+" es "+p2.calcularIMC());
        System.out.println("El IMC de "+p3.getNombre()+" es "+p3.calcularIMC());



        s.close();
    }
}
