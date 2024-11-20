
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
                    modelo.leerPersonas();
                    vista.mostrarMensaje("Personas importadas");
                    break;
                case 2:
                    vista.mostrarPersonas(modelo.getPersonaTabulada());
                    break;
                case 3:
                    continuar = false;
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Intente de nuevo.");
            }
        }
    }

   
}