package vista;

import model.Connexio;
import model.Persones;
import model.PersonesDAODB;

import java.sql.SQLException;
import java.util.ArrayList;

public class Persona {

    static String leftAlignFormat = "| %-15s | %-25s | %-25s |%n";

    public static void mostrarPersona(Persones p) {

        System.out.format(leftAlignFormat, p.getNom(), p.getCog1(), p.getCog2());
    }

    public static void mostrarPersones(ArrayList<Persones> persones) {
        System.out.println("-".repeat(75));
        System.out.format(leftAlignFormat, "Nom", "Primer Cognom", "Segon Cognom");
        System.out.println("-".repeat(75));
        for (Persones p: persones) {
            mostrarPersona(p);
        }
        System.out.println("-".repeat(75));
    }

    public static void main(String[] args) throws SQLException {
        ArrayList<Persones> list = new ArrayList<Persones>();
        list.add(new Persones(10, "Juan", "Perez", "Gonzalez"));
        list.add(new Persones(10, "Bruce", "Wayne", ""));
        list.add(new Persones(10, "John", "Smith", ""));
        list.add(new Persones(10, "Marc", "Peral", "Cajidos"));

        PersonesDAODB personesDAODB = new PersonesDAODB(Connexio.conectar());
        list = (ArrayList<Persones>) PersonesDAODB.read();


        Persona.mostrarPersones(list);
    }
}
