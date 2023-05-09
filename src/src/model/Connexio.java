package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexio {
    // Variables de conexión
    private final String URL = "jdbc:mysql://localhost:3306/jdbc-pt1";
    private final String USER = "root";
    private final String PASSWORD = "";
    private Connection conexion = null;

    // Método para establecer la conexión
    public Connection conectar() {
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.jdbc.Driver");

            // Establecer la conexión
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexió establerta");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al carregar el driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al connectar a la base de dades: " + e.getMessage());
        }

        return conexion;
    }

    // Método para cerrar la conexión
    public void desconectar() {
        try {
            if (conexion != null) {
                conexion.close();
                System.out.println("Conexió tancada");
            }
        } catch (SQLException e) {
            System.out.println("Error al tancar la connexió: " + e.getMessage());
        }
    }
}
