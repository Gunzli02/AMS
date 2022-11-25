package de.bs1bt.ams.db;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseTests {
    Connection connection;

    @BeforeEach
    private void getConnection(){
        try {
            connection = DBConnection.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    private void testTableReadPermission(){

    }
}
