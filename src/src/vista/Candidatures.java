package vista;

import model.Persones;

import java.util.ArrayList;

public class Candidatures {

    static String leftAlignFormat = "| %-5s | %-6s | %-30s | %-75s | %-6s | %-6s | %-6s |%n";

    public static void mostrarCandidatura(model.Candidatures c) {

        System.out.format(leftAlignFormat,
                c.getCandidatura_id(),
                c.getCodi_candidatura(),
                c.getNom_curt(),
                c.getNom_llarg(),
                c.getCodi_acumulacio_nacional(),
                c.getCodi_acumulacio_ca(),
                c.getCodi_acumulacio_nacional());
    }

    public static void mostrarCandidatures(ArrayList<model.Candidatures> candidatures) {
        System.out.println("-".repeat(108));
        System.out.format(leftAlignFormat,"ID", "Codi", "Nom Curt", "Nom llarc", "Acum prov", "Acum cat", "Acum nac");
        System.out.println("-".repeat(108));
        if (candidatures.size() != 0) {
            for (model.Candidatures c: candidatures) {
                mostrarCandidatura(c);
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