import java.util.Random;

public class DatosPersonales {
    private String nombre;
    private String apellidos;
    private int edad;
    private String NIF;

    public DatosPersonales(String nombre, String apellidos, int edad, String NIF) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.NIF = NIF;
    }

    public static DatosPersonales generarDatosPersonalesAleatorios() {
        Random random = new Random();
        String[] nombres = {"Juan", "Maria", "Carlos", "Ana", "Pedro"};
        String[] apellidos = {"Gonzalez", "Martinez", "Lopez", "Hernandez", "Perez"};
        String nombre = nombres[random.nextInt(nombres.length)];
        String apellido = apellidos[random.nextInt(apellidos.length)];
        int edad = random.nextInt(50) + 18; 
        String NIF = generarNIFAleatorio();

        return new DatosPersonales(nombre, apellido, edad, NIF);
    }

    private static String generarNIFAleatorio() {
        Random random = new Random();
        StringBuilder NIF = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            NIF.append(random.nextInt(10));
        }
        char letra = (char) (random.nextInt(26) + 'A');
        NIF.append(letra);
        return NIF.toString();
    }

    public String toCSV() {
        return nombre + "," + apellidos + "," + edad + "," + NIF;
    }
    @Override
    public String toString() {
        return nombre + " " + apellidos + ", Edad: " + edad + ", NIF: " + NIF;
    }
}
