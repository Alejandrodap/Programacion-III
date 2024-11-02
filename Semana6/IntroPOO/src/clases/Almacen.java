package clases;

import static com.coti.tools.Esdia.*;
import java.util.HashMap;
import java.util.Map;

public class Almacen {
    private HashMap<String, Libro> libros;

    public Almacen() {
        this.libros = new HashMap<>();
    }

    public void crearAlmacen() {
        this.libros.clear();
        System.out.println("Se ha creado un nuevo almacén de libros.");
    }

    public void añadirLibro() {
        String isbn = readString("Introduce el ISBN del libro:");
        if (libros.containsKey(isbn)) {
            System.out.println("Ya existe un libro con ese ISBN.");
            return;
        }

        Libro nuevoLibro = new Libro();
        Autor nuevoAutor = new Autor();
        nuevoAutor.setNombre(readString("Introduce el nombre del autor:"));
        nuevoAutor.setApellidos(readString("Introduce los apellidos del autor:"));
        nuevoAutor.setPremioPlaneta(siOno("¿Ha ganado el Premio Planeta? "));
        nuevoLibro.setAutor(nuevoAutor);
        nuevoLibro.setTitulo(readString("Introduce el título del libro: "));
        nuevoLibro.setPrecio(readFloat("Introduce el precio: ", 0.01f, 1000f));
        nuevoLibro.setPubli(readInt("Introduce el año de publicación: ", 0, 2024));
        nuevoLibro.setPags(readInt("Introduce el número de páginas: ", 1, 999999));

        libros.put(isbn, nuevoLibro);
        System.out.println("Libro añadido correctamente.");
    }

    public void eliminarLibro() {
        String isbn = readString("Introduce el ISBN del libro:");
        if (libros.containsKey(isbn)) {
            libros.remove(isbn);
            System.out.println("Libro eliminado correctamente.");
            return;            
        }
        System.out.println("No existe un libro con ese ISBN.");
    }

    public void actualizarLibro(){
        String isbn = readString("Introduce el ISBN del libro:");
        if (libros.containsKey(isbn)) {
            Libro libroActualizado = new Libro();
            Autor autorActualizado = new Autor();
            autorActualizado.setNombre(readString("Introduce el nombre del autor:"));
            autorActualizado.setApellidos(readString("Introduce los apellidos del autor:"));
            autorActualizado.setPremioPlaneta(siOno("¿Ha ganado el Premio Planeta? "));
            libroActualizado.setAutor(autorActualizado);
            libroActualizado.setTitulo(readString("Introduce el título del libro: "));
            libroActualizado.setPrecio(readFloat("Introduce el precio: ", 0.01f, 1000f));
            libroActualizado.setPubli(readInt("Introduce el año de publicación: ", 0, 2024));
            libroActualizado.setPags(readInt("Introduce el número de páginas: ", 1, 999999));
            libros.put(isbn,libroActualizado);
            return;
        }
        System.out.println("No existe un libro con ese ISBN.");
    }
    
    public void mostrarLibros(float ritmoLectura) {
        if (libros.isEmpty()) {
            System.out.println("No hay libros en el almacén.");
            return;
        }

        System.out.println("|-----------------------------------------------------------------------------------------------------------------------|");
        System.out.println("|                                              LIBROS EN EL ALMACÉN                                                     |");
        System.out.println("|-----------------------------------------------------------------------------------------------------------------------|");
        System.out.println("| ISBN               | Título             | Año Publicación | Autor               | Premio Planeta | Páginas | Tiempo Lectura min | Precio € |");
        System.out.println("|-----------------------------------------------------------------------------------------------------------------------|");

        float tiempoTotal = 0;
        float precioTotal = 0;
        
        for (Map.Entry<String, Libro> entry : libros.entrySet()) {
            String isbn = entry.getKey();
            Libro libro = entry.getValue();
            Autor autor = libro.getAutor();

            String titulo = libro.getTitulo();
            int añoPubli = libro.getPubli();
            String nombreAutor = autor.getNombre() + " " + autor.getApellidos();
            String premioPlaneta = autor.isPremioPlaneta() ? "Sí" : "No";
            int paginas = libro.getPags();
            float tiempoLectura = paginas / ritmoLectura;
            float precio = libro.getPrecio();
            tiempoTotal += tiempoLectura;
            precioTotal += precio;

            System.out.printf("| %-18s | %-18s | %-15d | %-18s | %-13s | %-7d | %-18.2f | %.2f € |\n", 
                              isbn, titulo, añoPubli, nombreAutor, premioPlaneta, paginas, tiempoLectura, precio);
        }

        System.out.println("|-----------------------------------------------------------------------------------------------------------------------|");
        System.out.printf("| Tiempo de lectura total del almacén:                                                                      %.2f min |\n", tiempoTotal);
        System.out.printf("| Valor total del almacén:                                                                                       %.2f€|\n", precioTotal);
        System.out.println("|-----------------------------------------------------------------------------------------------------------------------|");
    }
}
