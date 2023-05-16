package vista;

import java.util.ArrayList;

public class Candidatures {

    static String leftAlignFormat = "| %-5s | %-6s | %-30s | %-75s | %-10s | %-10s | %-10s |%n";

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
        System.out.println("-".repeat(168));
        System.out.format(leftAlignFormat,"ID", "Codi", "Nom Curt", "Nom llarc", "Acum prov", "Acum cat", "Acum nac");
        System.out.println("-".repeat(168));
        if (candidatures.size() != 0) {
            for (model.Candidatures c: candidatures) {
                mostrarCandidatura(c);
            }
        }else {
            System.out.format("| %-104s |\n", "No s'han trobat resultats");
        }
        System.out.println("-".repeat(168));
    }

    public static void main(String[] args) {
//        ArrayList<model.Candidatures> list = new ArrayList<model.Candidatures>();
//        list.add(
//                new model.Candidatures(
//                        9999,
//                        1,
//                        0,
//                        "AHORA CANAR",
//                        "AHORA CANARIAS: Alternativa Nacionalista",
//                        0,
//                        0,
//                        0
//                ));
//
//        mostrarCandidatures(list);
    }
}