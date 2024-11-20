
public class Controlador {
    private Modelo modelo;
    private Vista vista;

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        boolean continuar = true;

        while (continuar) {
            vista.mostrarMenu();
            int opcion = vista.solicitarOpcion();
            switch (opcion) {
                case 1:
                    modelo.crearRandom();
                    vista.mostrarMensaje("Datos creados");
                    break;
                case 2:
                    //mostrar info
                    modelo.mostrarAlumnos();
                    break;
                case 3:
                    //exportar datos personales csv
                    modelo.exportarDireccionesCSV();
                    vista.mostrarMensaje("Datos de direcciones exportados");
                    break;
                case 4:
                    //exportar direcciones csv
                    modelo.exportarDatosAlumnoCSV();
                    vista.mostrarMensaje("Datos personales de alumnos exportados");
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Intente de nuevo.");
            }
        }
    }

    
   
}