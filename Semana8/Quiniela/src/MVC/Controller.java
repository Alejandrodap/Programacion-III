package MVC;

// Controlador: QuinielaControlador.java


public class Controller {
    private Modelo quiniela;
    private Vista vista;

    public Controller(Modelo quiniela, Vista vista) {
        this.quiniela = quiniela;
        this.vista = vista;
    }

    public void run() {
        int opcion;
        do {
            vista.mostrarMenu();
            quiniela.leerPartidos();
            opcion = vista.solicitarOpcion();
            switch (opcion) {
                case 1:
                    Partido partido = vista.solicitarPartido();
                    quiniela.agregarPartido(partido);
                    break;
                case 2:

                    vista.mostrarResultados(quiniela.mostrarPartidos());
                    break;
                case 3:
                    vista.mostrarQuiniela(quiniela.mostrarPartidos());
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);
    }
}
