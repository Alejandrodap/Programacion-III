import MVC.*;

public class App {
    public static void main(String[] args) throws Exception {
        Vista vista = new Vista();
        Modelo modelo = new Modelo();
        Controller controlador = new Controller(modelo,vista);
        controlador.run();
    }
}
