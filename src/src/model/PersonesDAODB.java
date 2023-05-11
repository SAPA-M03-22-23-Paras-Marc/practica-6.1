package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonesDAODB implements DAODB<Persones> {

    private Connection connection;

    public PersonesDAODB(Connection connection) {
        this.connection = connection;
    }

    public static Object read() {
        read();
        return true;
    }

    @Override
    public boolean create(Persones persona) {
        try {
            String sql = "INSERT INTO persones (persona_id, nom, cog1, cog2) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, persona.getPersona_id());
            statement.setString(2, persona.getNom());
            statement.setString(3, persona.getCog1());
            statement.setString(4, persona.getCog2());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean read(Persones persona) {
        try {
            String sql = "SELECT * FROM persones WHERE persona_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, persona.getPersona_id());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nom = resultSet.getString("nom");
                String cog1 = resultSet.getString("cog1");
                String cog2 = resultSet.getString("cog2");
                persona.setNom(nom);
                persona.setCog1(cog1);
                persona.setCog2(cog2);
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Persones persona) {
        try {
            String sql = "UPDATE persones SET nom=?, cog1=?, cog2=? WHERE persona_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, persona.getNom());
            statement.setString(2, persona.getCog1());
            statement.setString(3, persona.getCog2());
            statement.setInt(4, persona.getPersona_id());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Persones persona) {
        try {
            String sql = "DELETE FROM persones WHERE persona_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, persona.getPersona_id());
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean exists(Persones persona) {
        try {
            String sql = "SELECT * FROM persones WHERE persona_id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, persona.getPersona_id());
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int count() {
        try {
            String sql = "SELECT COUNT(*) FROM persones";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Persones> all() {
        List<Persones> persones = new ArrayList<>();
        try {
            String sql = "SELECT * FROM persones";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int persona_id = resultSet.getInt("persona_id");
                String nom = resultSet.getString("nom");
                String cog1 = resultSet.getString("cog1");
                String cog2 = resultSet.getString("cog2");
                String sexe = resultSet.getString("sexe");
                Date dataNaixement = resultSet.getDate("data_naixement");
                String dni = resultSet.getString("dni");

                Persones persona = new Persones(persona_id, nom, cog1, cog2, sexe, dataNaixement, dni);
                persones.add(persona);

            }

            return persones;

        } catch (SQLException e) {

            e.printStackTrace();

            return persones;

        }
    }
}
