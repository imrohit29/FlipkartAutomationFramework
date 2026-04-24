package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBUtil {
    private static Connection connection;
    private static final Logger logger = LogManager.getLogger(DBUtil.class);

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                String url = ConfigReader.getProperty("db.url");
                String user = ConfigReader.getProperty("db.username");
                String pass = ConfigReader.getProperty("db.password");
                connection = DriverManager.getConnection(url, user, pass);
                logger.info("Database connection established.");
            }
        } catch (SQLException e) {
            logger.error("Failed to connect to database. " + e.getMessage());
            // Intentionally not throwing exception so we can mock/simulate in test
        }
        return connection;
    }

    public static ResultSet executeQuery(String query) {
        ResultSet rs = null;
        try {
            Connection conn = getConnection();
            if (conn != null) {
                Statement stmt = conn.createStatement();
                rs = stmt.executeQuery(query);
            } else {
                logger.warn("Simulating DB validation - connection is null.");
            }
        } catch (SQLException e) {
            logger.error("Error executing query: " + query, e);
        }
        return rs;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                logger.info("Database connection closed.");
            }
        } catch (SQLException e) {
            logger.error("Error closing database connection", e);
        }
    }
}
