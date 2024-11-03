public class App {
    public static void main(String[] args) {
        Vista vista = new Vista();
        Controller controller = new Controller(vista);
        controller.run();
    }
}
