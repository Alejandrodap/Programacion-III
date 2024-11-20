import java.util.Random;

public class Direccion {
    private String calle;
    private int numero;
    private int piso;
    private String letra;

    public Direccion(String calle, int numero, int piso, String letra) {
        this.calle = calle;
        this.numero = numero;
        this.piso = piso;
        this.letra = letra;
    }

    public static Direccion generarDireccionAleatoria() {
        Random random = new Random();
        String[] calles = {"Calle A", "Calle B", "Calle C", "Calle D"};
        String calle = calles[random.nextInt(calles.length)];
        int numero = random.nextInt(100) + 1;
        int piso = random.nextInt(6) + 1;
        String letra = String.valueOf((char) (random.nextInt(26) + 'A'));

        return new Direccion(calle, numero, piso, letra);
    }

    public String toCSV() {
        return calle + "," + numero + "," + piso + "," + letra;
    }
    
    @Override
    public String toString() {
        return calle + " " + numero + ", Piso " + piso + ", Letra " + letra;
    }
}

