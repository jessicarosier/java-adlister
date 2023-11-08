package com.codeup.adlister.dao;

import com.codeup.adlister.models.Categories;
import dao.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQLCategoryDao implements Categories {
    private Connection connection;

    public MySQLCategoryDao(Config config) {
        try {
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }
}
