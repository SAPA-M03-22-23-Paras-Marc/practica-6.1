package vista;

public class Persona {

    String nom;
    String cognom1;
    String cognom2;
    String sexe;
    String dataNaixement;
    String dni;

    public Persona(String nom, String cognom1, String cognom2, String sexe, String dataNaixement, String dni) {
        this.nom = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
        this.sexe = sexe;
        this.dataNaixement = dataNaixement;
        this.dni = dni;
    }

    public void mostrarPersona() {
        System.out.println(nom + cognom1 + cognom2 + sexe + dataNaixement + dni);
    }


}
