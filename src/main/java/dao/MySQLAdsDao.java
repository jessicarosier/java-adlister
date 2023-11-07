package dao;

import com.mysql.cj.jdbc.Driver;
import models.Ad;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MySQLAdsDao implements Ads {

    private Connection connection;

    private List<Ad> ads;

    public MySQLAdsDao(Config config) throws SQLException {
        DriverManager.registerDriver(new Driver());
        this.connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
        );
    }

    @Override
    public List<Ad> all() throws SQLException {
           this.ads = new ArrayList<>();
            Statement statement = connection.createStatement();
            String selectQuery = "SELECT * FROM ads";
            ResultSet rs = statement.executeQuery(selectQuery);
            while (rs.next()) {
                Ad ad = new Ad(
                        rs.getLong("id"),
                        rs.getInt("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                );
                ads.add(ad);
            }

        return ads;
    }

    @Override
    public Long insert(Ad ad) {

        try {
            Statement statement = connection.createStatement();
            String insertQuery = "INSERT INTO ads (title, description, user_id) VALUES ('" + ad.getTitle() + "', '" + ad.getDescription() + "', " + ad.getUserId() + ")";
            statement.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return (long) Statement.RETURN_GENERATED_KEYS;
    }

    @Override
    public void delete(String id) throws SQLException {
        Statement statement = connection.createStatement();
        String deleteQuery = "DELETE FROM ads WHERE id = " + id + "";
        statement.execute(deleteQuery);
    }


}
