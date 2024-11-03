
public class Coche {

    private String modelo;
    private String marca;
    private String matricula;
    private int anio;
    private double precio;
    final double IVA = 21;

    // Constructores
    public Coche(String matricula) {
        this.matricula = matricula;
    }

    public Coche(String modelo, String marca, String matricula, int anio, double precio) {
        this.modelo = modelo;
        this.marca = marca;
        this.matricula = matricula;
        this.anio = anio;
        this.precio = precio;
    }

    // métodos getter y setter

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getPrecioSinIVA() {
        return precio;
    }

    public void setPrecioSinIVA(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return "Coche [modelo= " + modelo + ", marca= " + marca + ", matricula= " + matricula + "  , anio= " + anio
                + " , precio= " + precio + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coche other = (Coche) obj;
        if (matricula == null) {
            if (other.matricula != null)
                return false;
        } else if (!matricula.equals(other.matricula))
            return false;
        return true;
    }

}
