package daos;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConn {
    public static final String URL = "jdbc:mysql://localhost:3309/main";
    public static final String USER = "root";
    public static final String PASS = "password";
    /**
     * Get a connection to database
     * @return Connection object
     */
    public static Connection getConnection()
    {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }
    /**
     * Test Connection
     */
    public static void main(String[] args) {
        Connection connection = DatabaseConn.getConnection();
    }
}
