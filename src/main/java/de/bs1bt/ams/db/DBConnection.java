package de.bs1bt.ams.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection = null;
    private static String url = "jdbc:mysql://localhost:3306/ams_fx_test";
    private static String user = "schueler";
    private static String password = "Geheim01";

    private DBConnection() {}
    public static Connection getConnection() throws SQLException {
        if(null == connection || connection.isClosed()) {
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }
}
