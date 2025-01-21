package com.projetCC.repository;
import com.projetCC.domain.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository implements IRepository<User> {

    private final String TABLE = "users";
    private final String ID = "id";
    private final String NAME = "userName";
    private final String PASSWORD = "password";
    private final String MAIL = "mail";

    @Override
    public User findById(int id) {
        String query = "SELECT * FROM " + TABLE + " WHERE " + ID + " = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                return new User(
                        resultSet.getInt(ID),
                        resultSet.getString(NAME),
                        resultSet.getString(PASSWORD),
                        resultSet.getString(MAIL)
                );
            } else {
                System.out.println("User not found for id : " + id);
            }
        } catch (SQLException e) {
            System.err.println("SQL error for query : " + query);
            System.err.println(e.getMessage());
        }

        return null;
    }

    public User findByMail(String mail) {
        String query = "SELECT * FROM " + TABLE + " WHERE " + MAIL + " = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, mail);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                return new User(
                        resultSet.getInt(ID),
                        resultSet.getString(NAME),
                        resultSet.getString(PASSWORD),
                        resultSet.getString(MAIL)
                );
            } else {
                System.out.println("User not found for mail : " + mail);
            }
        } catch (SQLException e) {
            System.err.println("SQL error for query : " + query);
            System.err.println(e.getMessage());
        }

        return null;

    }
}
