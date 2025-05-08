//Este es el codigo principal
//En liberia esta el borrador con mas implementaciones pero imcompletas
//Las personas se representan con variables

import java.util.*;
import java.io.*;

// Clase Libro
class Libro {
    private String nombre;
    private String autor;

    // Constructor
    public Libro(String nombre, String autor) {
        this.nombre = nombre;
        this.autor = autor;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getAutor() { return autor; }

    // Método para imprimir la información del libro
    @Override
    public String toString() {
        return nombre + " de " + autor;
    }
}

// Clase Menu
class Menu {
    private String familia;
    private List<Libro> libros = new ArrayList<>();

    public Menu(String familia) {
        this.familia = familia;
    }

    public String getFamilia() { return familia; }
    public List<Libro> getLibros() { return libros; }

    // Agrega un libro al menú
    public void add(Libro p) { libros.add(p); }

    // Muestra todos los libros completos
    @Override
    public String toString() {
        String s = familia + ":\n";
        for (int i = 0; i < libros.size(); i++)
            s += "  " + (i + 1) + ". " + libros.get(i) + "\n";
        return s;
    }
}

// Clase Registro
class Registro {
    private List<Libro> lista = new ArrayList<>();

    public void add(Libro p) { lista.add(p); }

    // Muestra el registro de libros completo
    @Override
    public String toString() {
        String s = "Registro de libros:\n";
        for (Libro p : lista) s += "- " + p + "\n";
        s += "TOTAL: $" + total();
        return s;
    }

    // Método para calcular el total (simulado)
    public int total() {
        return lista.size() * 20; // Suponiendo un precio fijo por libro
    }

// Clase principal
public class BIBLIOTECA {
    static List<Menu> menus = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initMenus(); // Inicializa los menús con libros
        OUTER:
        while (true) {
            System.out.println("\n1. Ver Menús   2. Alquilar libros   3. Salir");
            System.out.print("→ ");
            int op = sc.nextInt();
            // Manejo de opciones del menú
            switch (op) {
                case 1 -> verMenus(); // Ver todos los menús
                case 2 -> AlquilarLibro(); // Alquilar libro
                default -> {
                    break OUTER; // Salir del programa
                }
            }
        }
        System.out.println("¡Hasta luego!");
    }

    // Inicializa los menús y sus libros
    static void initMenus() {
        Menu m1 = new Menu("Libros de Ingeniería");
        m1.add(new Libro("La ingeniería es humana", "Henry Petroski"));
        m1.add(new Libro("El teorema del loro", "Denis Guedj"));
        m1.add(new Libro("La psicología de los objetos cotidianos", "Donald Norman"));
        m1.add(new Libro("Planilandia: una novela de muchas dimensiones", "Edwin Abbott"));
        m1.add(new Libro("Un ingeniero imagina", "Peter Rice"));

        Menu m2 = new Menu("Libros de Filosofía");
        m2.add(new Libro("Diálogos de Platón", "Apología de Sócrates"));
        m2.add(new Libro("Ética a Nicómaco", "Aristóteles"));
        m2.add(new Libro("Leviátan", "Thomas Hobbes"));
        m2.add(new Libro("El Príncipe", "Nicolás Maquiavelo"));
        m2.add(new Libro("El Mundo de Sofía", "Jostein Gaarder"));

        Menu m3 = new Menu("Libros de Neurología");
        m3.add(new Libro("Neurología", "Federico Micheli"));
        m3.add(new Libro("Fundamentos de Neurología. Semiología Clínica y Fisiopatología", "José Tejeiro Martínez"));
        m3.add(new Libro("Tratado de neurología clínica", "Jorge Nogales Gaete"));
        m3.add(new Libro("Manual de Neurología", "Rolando J. Giannaula"));
        m3.add(new Libro("Manual de Neurología: para el interno y médico general", "Renato Verdugo Latorre"));

        // Añadir menús a la lista global
        menus.add(m1);
        menus.add(m2);
        menus.add(m3);
    }

    // Mostrar todos los menús y sus libros
    static void verMenus() {
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + ". " + menus.get(i));
        }
    }

    // Realizar un Registro de libros
    static void AlquilarLibro() {
        Registro ped = new Registro(); // Nuevo registro

        while (true) {
            verMenus(); // Mostrar menús disponibles
            System.out.print("Elige menú (1-3) o 0 fin: ");
            int m = sc.nextInt();
            if (m == 0) break; // Termina el registro
            if (m < 1 || m > 3) continue; // Validar opción

            Menu sel = menus.get(m - 1); // Seleccionar menú
            System.out.println(sel);
            System.out.print("Elige un libro (1-5): ");
            int p = sc.nextInt();
            if (p >= 1 && p <= 5) {
                // Agregar libro al registro
                Libro elegido = sel.getLibros().get(p - 1);
                ped.add(elegido);
                System.out.println("Agregado: " + elegido.getNombre());
            }
        }
    }
}
 
