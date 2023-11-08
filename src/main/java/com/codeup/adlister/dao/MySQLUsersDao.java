package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;
import dao.Config;

import java.sql.*;

public class MySQLUsersDao implements Users{

    private Connection connection;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }

    }
    @Override
    public User findByUsername(String username) {
        try {
            String sql = "SELECT * FROM users WHERE username LIKE ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                User matchedUser = new User(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password")
                );
                return matchedUser;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving user.", e);
        }

    }

    @Override
    public Long insert(User user) {
        try {
            String insertQuery = "INSERT INTO users (username, email, password)  VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if( rs.next()){
                System.out.println(rs.getLong(1));
                return rs.getLong(1);

            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new user.", e);
        }

    }
}
