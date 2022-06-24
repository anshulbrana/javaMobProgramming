package tests;


import datamodel.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import services.data.ContactCsvDAO;
import services.database.Configuration;

import java.sql.*;

public class TestSPR4 {

    static {
        System.setProperty("conf.file","src/test/resources/conf.properties");
    }

    private Connection cnt;

    public void testDatabase(){
        Configuration conf = Configuration.getInstance();
    }


    @BeforeEach
    public void initialize() throws SQLException {
        // TO create a table in in-memory database
        this.cnt = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "username", "password");
        PreparedStatement preparedStatement = cnt.prepareStatement("CREATE TABLE IF NOT EXISTS contact (firstName VARCHAR(255), lastName VARCHAR(255), phone1 VARCHAR(255), phone VARCHAR(255), email VARCHAR(255), state VARCHAR(255))");
        preparedStatement.execute();
    }


    @Test
    public void test() throws SQLException {

        Connection connection = cnt;
        ResultSet resultSet = connection.prepareStatement("select * from contact where name = 'test'").executeQuery();
        String retrievedName = null;

        while (resultSet.next()) {
            retrievedName = resultSet.getString("name");
        }

        if (retrievedName == null) {
            throw new RuntimeException("Name test was not found, expected to be not null");
        }
    }
}
