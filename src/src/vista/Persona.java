package vista;

import model.Persones;

import java.util.ArrayList;

public class Persona {

    static String leftAlignFormat = "| %-5s | %-30s | %-30s | %-30s |%n";

    public static void mostrarPersona(Persones p) {

        System.out.format(leftAlignFormat,p.getPersona_id(), p.getNom(), p.getCog1(), p.getCog2());
    }

    public static void mostrarPersones(ArrayList<Persones> persones) {
        System.out.println("-".repeat(108));
        System.out.format(leftAlignFormat,"ID", "Nom", "Primer Cognom", "Segon Cognom");
        System.out.println("-".repeat(108));
        if (persones.size() != 0) {
            for (Persones p: persones) {
                mostrarPersona(p);
            }
        }else {
            System.out.format("| %-104s |\n", "No s'han trobat resultats");
        }
        System.out.println("-".repeat(108));
    }

    public static void main(String[] args) {
//        ArrayList<Persones> list = new ArrayList<Persones>();
//        list.add(new Persones(10, "Juan", "Perez", "Gonzalez"));
//        list.add(new Persones(10, "Bruce", "Wayne", ""));
//        list.add(new Persones(10, "John", "Smith", ""));
//        list.add(new Persones(10, "Marc", "Peral", "Cajidos"));
//        Persones p = new Persones(10, "Juan", "Perez", "Gonzalez");
//        PersonesDAODB pDAODB = new PersonesDAODB(Connexio.conectar());
//        list = (ArrayList<Persones>) pDAODB.all();
//
//
//        Persona.mostrarPersones(list);
    }
}
