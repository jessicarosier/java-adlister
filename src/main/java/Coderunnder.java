//import com.mysql.cj.jdbc.Driver;
//
//import javax.servlet.jsp.jstl.core.Config;
//import java.sql.*;
//
//public class Coderunnder {
//
//    public static void main(String[] args) throws SQLException {
//
//        DriverManager.registerDriver(new Driver());
//        config configObj = new config();
//        Connection localConnection = DriverManager.getConnection(
//                configObj.getUrl(),
//                configObj.getUser(),
//                configObj.getPassword()
//
//        );
//
//        Statement statement = localConnection.createStatement();
////        System.out.println("Result of executing the delete statement");
////        statement.execute("DELETE FROM albums WHERE id = 5");
////
////        System.out.println("Insert a new album into thr albums table");
////        statement.execute("INSERT INTO albums (artist_name, album_name, release_date, sales, genre) VALUES ('Gorillaz', 'Demon Days', 2005, 10.2, 'Hip-Hop')");
////        String selectQuery = "SELECT * FROM albums";
////        ResultSet rs = statement.executeQuery(selectQuery);
////        while (rs.next()) {
////            System.out.println("artist: " + rs.getString("artist_name"));
////            System.out.println("album name: " + rs.getString("album_name"));
////            System.out.println("id: " + rs.getInt("id"));
////        }
//
////        String query = "INSERT INTO albums (artist_name, album_name, release_date, genre, sales) VALUES('Nelly Furtado', 'Loose', 2006, 'Pop, Urban, R&B', 12.5)";
////        statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
////        ResultSet rs = statement.getGeneratedKeys();
////        if (rs.next()) {
////            System.out.println("Inserted a new record! New id: " + rs.getLong(1));
////        }
//
//
//    }
//}
