package model;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//TODO: Alumnes > crear una bdd amb les taules i dades per a poder executar aquest codi
//TODO: Provar de canviar la connexió Statement per PreparedStatement
//TODO: transformar aquesta classe per a que no només executi les operacions CRUD, sinó que els clients i les comandes siguin objectes >> Encarrecsv2
//CRUD: Create Read Update Delete

public class Connexio {

    public static void main(String[] args) {

        String bdd = "jdbc:mysql://127.0.0.1:3306/test_jdbc";
        String user = "root";
        String password = "";

        try {
            Connection conn = DriverManager.getConnection(bdd, user, password);  //instància Connection
            String sql = "SELECT * FROM clients";
            Statement stmt = conn.createStatement();  //instanciem Statement
            ResultSet resultat = stmt.executeQuery(sql);  //instranciem ResultSet
            //mostrar dades per pantalla resultat de la sentencia sql
            while (resultat.next()) {
                String nomClient = resultat.getString("nom");
                System.out.println("Client: " + nomClient);
            }
            //tancament de la connexio
            resultat.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error de connexió a la base de dades: " + e.getMessage());
        }


        /* si no volem tirar d'API, passar les dades d'un objecte als camps de la taula seria quelcom semblant a això:
         * public void insertarClient(Client client) throws SQLException {
         *     String sql = "INSERT INTO clients (nom, cognoms, adreça, telèfon) VALUES (?, ?, ?, ?)";
         *     PreparedStatement statement = conn.prepareStatement(sql);
         *     statement.setString(1, client.getNom());
         *     statement.setString(2, client.getCognoms());
         *     statement.setString(3, client.getAdreça());
         *     statement.setString(4, client.getTelèfon());
         *     statement.executeUpdate();
         * } **/
    }
}