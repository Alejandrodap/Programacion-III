public class Persona {
    private String nombre;
    private int numero;
    private double peso;

    public Persona(String nombre, int numero, double peso) {
        this.nombre = nombre;
        this.numero = numero;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }

    public double getPeso() {
        return peso;
    }

    public String toString(){
        return nombre+"\t"+numero+"\t"+peso;
    }
   
}