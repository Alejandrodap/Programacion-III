


public class C {
    private M model;
    private V view;
    private boolean ventas=false;
    private boolean precios=false;
    public C(M model, V view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        boolean running = true;
        while (running) {
            view.menu();
            String option = view.leerOpcion();
            switch (option) {
                case "1":
                    int almacen=view.getInt("Selecciona un almacen",1,5);
                    int producto=view.getInt("Selecciona un producto",0,1);
                    int  unidades=view.getInt("Introduce las unidades",1,9999);
                    model.setVentas(almacen,producto,unidades);
                    ventas=true;
                    break;
                case "2":
                    double precio0=view.getDouble("Introduce el precio del primer articulo", 0, 9999);
                    double precio1=view.getDouble("Introduce el precio del segundo articulo", 0, 9999);
                    model.setPrecios(precio0,precio1);
                    precios=true;
                    break;
                case "3":
                    if (precios &&  ventas) {
                        double ingresos=model.calcularIngresosTotales();
                        view.mostrarMensaje("Los ingresos totales son: "+ingresos+"€");                   
                    }else{
                        view.mostrarMensaje("No se han introducido los datos necesarios");
                    }
                    break;
                case "4":
                    if (precios  && ventas) {
                        view.mostrarMensaje("Ventas: ");
                        view.mostrarVentas(model.getVentas()); 

                        view.mostrarMensaje("Precios: ");
                        view.mostrarPrecios(model.getPrecios());
                    }else{
                        view.mostrarMensaje("No se han introducido los datos necesarios");
                    }
                    break;
                case "q":
                    running = false;
                    view.mostrarMensaje("Saliendo del programa. ¡Adiós!");
                    break;
                default:
                    view.mostrarMensaje("Opción inválida, intente nuevamente.");
                    break;
            }
        }
    }
}
