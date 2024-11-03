public class M {
    private static int[][] ventas  = new int[5][2]; //5 calmacen 2 producto
    private static double[] precios = new double[2];

    public void setPrecios (double producto0, double producto1){
        precios[0]=producto0;
        precios[1]=producto1;
    }

    public void setVentas (int almacen , int producto , int unidades){
        ventas[almacen][producto]=unidades;
    }

    public double calcularIngresosTotales(){
        double ingresosTotales=0;
        for(int i =0;i<ventas.length;i++){
            for(int j =0;j<ventas[i].length;j++){
                ingresosTotales+=ventas[i][j]* precios[j];
            }
        }
        return ingresosTotales;
    }

    public int[][] getVentas() {
        return ventas;
    }

    public double[] getPrecios() {
        return precios;
    }

}
