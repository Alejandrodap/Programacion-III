

public class App {
    public static void main(String[] args) throws Exception {
        
        Model model = new Model();
        Vista view = new Vista();
        Controller controller = new Controller(model,view );
        controller.run();
    }
}
