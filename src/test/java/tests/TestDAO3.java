package tests;

import org.junit.jupiter.api.BeforeEach;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDAO3 {
    private Connection cnt;

    @BeforeEach
    public void initialize() throws SQLException {
        // TO create a table in in-memory database
        this.cnt = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "username", "password");
        PreparedStatement preparedStatement = cnt.prepareStatement("CREATE TABLE IF NOT EXISTS contact (firstName VARCHAR(255), lastName VARCHAR(255), phone1 VARCHAR(255), phone VARCHAR(255), email VARCHAR(255), state VARCHAR(255))");
        preparedStatement.execute();


    }
}
