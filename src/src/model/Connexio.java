package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexio {
    // Variables de conexión
    private static  final String URL = "jdbc:mysql://localhost:3306/jdbc-pt1";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static  Connection connexio = null;

    // Método para establecer la conexión
    public static Connection conectar() {
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.jdbc.Driver");

            // Establecer la conexión
            connexio = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexió establerta");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al carregar el driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al connectar a la base de dades: " + e.getMessage());
        }

        return connexio;
    }

    // Método para cerrar la conexión
    public void desconectar() {
        try {
            if (connexio != null) {
                connexio.close();
                System.out.println("Conexió tancada");
            }
        } catch (SQLException e) {
            System.out.println("Error al tancar la connexió: " + e.getMessage());
        }
    }

    public Connection getConnexio() {
        return connexio;
    }
}
