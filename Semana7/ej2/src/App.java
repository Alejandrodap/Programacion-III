

public class App {
    public static void main(String[] args) throws Exception {
        
        M model = new M();
        V view = new V();
        C controller = new C(model,view );
        controller.run();
    }
}
