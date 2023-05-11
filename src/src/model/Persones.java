package model;

public class Persones {

    int persona_id;
    String nom;
    String cog1;
    String cog2;

    public Persones( String nom, String cog1, String cog2) {
        this.nom = nom;
        this.cog1 = cog1;
        this.cog2 = cog2;

    }


    public Persones(int persona_id, String nom, String cog1, String cog2) {
        this.persona_id = persona_id;
        this.nom = nom;
        this.cog1 = cog1;
        this.cog2 = cog2;

    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCog1(String cog1) {
        this.cog1 = cog1;
    }

    public void setCog2(String cog2) {
        this.cog2 = cog2;
    }

    public int getPersona_id() {
        return persona_id;
    }

    public String getNom() {
        return nom;
    }

    public String getCog1() {
        return cog1;
    }

    public String getCog2() {
        return cog2;
    }

    /*
    public void mostrarPersona() {
        System.out.println(nom + cognom1 + cognom2 + sexe + dataNaixement + dni);
    }

 */


}
