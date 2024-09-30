public class Person {
    private String nombre ;
    private float altura;
    private float peso;

    public Person() {}

    public Person(String nombre, float altura, float peso) {
        this.nombre = nombre;
        this.altura = altura;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float calcularIMC() {
        if (altura <= 0 || peso <= 0) {
            return -1;
        }
        return peso / (altura * altura);
    }
}
