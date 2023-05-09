package model;

public class Candidats {
    int provincia_id, persona_id, candidatura_id;
    String nom, cog1, cog2;



    public Candidats(int provincia_id, int persona_id, int candidatura_id, String nom, String cog1, String cog2){
        this.provincia_id = provincia_id;
        this.persona_id = persona_id;
        this.candidatura_id = candidatura_id;
        this.nom  = nom;
        this.cog1 = cog1;
        this.cog2 = cog2;
    }

    public void setProvincia_id(int provincia_id) {
        this.provincia_id = provincia_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    public void setCandidatura_id(int candidatura_id) {
        this.candidatura_id = candidatura_id;
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

    public int getProvincia_id() {
        return provincia_id;
    }

    public int getPersona_id() {
        return persona_id;
    }

    public int getCandidatura_id() {
        return candidatura_id;
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
}
