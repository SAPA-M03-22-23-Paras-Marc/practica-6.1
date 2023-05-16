package model;

public class Candidatures {
    int candidatura_id, eleccio_id, codi_candidatura, codi_acumulacio_provincia,codi_acumulacio_ca, codi_acumulacio_nacional;
    String  nom_curt, nom_llarg;

    public Candidatures(int candidatura_id, int eleccio_id, int codi_candidatura,String nom_curt, String nom_llarg, int codi_acumulacio_provincia, int codi_acumulacio_ca, int codi_acumulacio_nacional) {
        this.candidatura_id = candidatura_id;
        this.eleccio_id = eleccio_id;
        this.codi_candidatura = codi_candidatura;
        this.nom_curt = nom_curt;
        this.nom_llarg = nom_llarg;
        this.codi_acumulacio_provincia = codi_acumulacio_provincia;
        this.codi_acumulacio_ca = codi_acumulacio_ca;
        this.codi_acumulacio_nacional = codi_acumulacio_nacional;

    }

    public Candidatures(String nomCandidatura) {
        this.nom_llarg = nomCandidatura;
    }

    public void setCandidatura_id(int candidatura_id) {
        this.candidatura_id = candidatura_id;
    }

    public void setEleccio_id(int eleccio_id) {
        this.eleccio_id = eleccio_id;
    }

    public void setCodi_candidatura(int codi_candidatura) {
        this.codi_candidatura = codi_candidatura;
    }

    public void setCodi_acumulacio_provincia(int codi_acumulacio_provincia) {
        this.codi_acumulacio_provincia = codi_acumulacio_provincia;
    }

    public void setCodi_acumulacio_ca(int codi_acumulacio_ca) {
        this.codi_acumulacio_ca = codi_acumulacio_ca;
    }

    public void setCodi_acumulacio_nacional(int codi_acumulacio_nacional) {
        this.codi_acumulacio_nacional = codi_acumulacio_nacional;
    }

    public void setNom_curt(String nom_curt) {
        this.nom_curt = nom_curt;
    }

    public void setNom_llarg(String nom_llarg) {
        this.nom_llarg = nom_llarg;
    }

    public int getCandidatura_id() {
        return candidatura_id;
    }

    public int getEleccio_id() {
        return eleccio_id;
    }

    public int getCodi_candidatura() {
        return codi_candidatura;
    }

    public int getCodi_acumulacio_provincia() {
        return codi_acumulacio_provincia;
    }

    public int getCodi_acumulacio_ca() {
        return codi_acumulacio_ca;
    }

    public int getCodi_acumulacio_nacional() {
        return codi_acumulacio_nacional;
    }

    public String getNom_curt() {
        return nom_curt;
    }

    public String getNom_llarg() {
        return nom_llarg;
    }
}
