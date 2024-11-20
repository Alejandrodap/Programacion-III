public class DatosDeAlumno {
    private Direccion direccion;
    private DatosPersonales datosAlmuno;

    public DatosDeAlumno(Direccion direccion, DatosPersonales datosAlmuno) {
        this.direccion = direccion;
        this.datosAlmuno = datosAlmuno;
    }

    public Direccion getDireccion() {
        return direccion;
    }
    public DatosPersonales getDatosAlmuno() {
        return datosAlmuno;
    }
    @Override
    public String toString() {
        return datosAlmuno.toString() + ", Dirección: " + direccion.toString();
    }
    
}
