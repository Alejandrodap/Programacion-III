package Semana4;

public class SumArg {
    public static void main(String[] args) throws Exception {
        if (args.length!=2) {
            System.out.println("Introduce  2 numeros");

        }
        try{
            int n1=Integer.parseInt(args[0]);
            int n2=Integer.parseInt(args[1]);
            int suma=n1+n2;
            System.out.println("La suma es: "+suma);

        }catch(NumberFormatException e){
            System.out.println("El argumento no es un numero");
            System.exit(1);

        }
    }
}