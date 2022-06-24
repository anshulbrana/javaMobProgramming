package tests;

import conf.AppConfiguration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import services.database.Configuration;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.*;

@ExtendWith(SpringExtension.class)

@ContextConfiguration(classes = {AppConfiguration.class})


public class TestSPR4 {

    static {
        System.setProperty("conf.file", "src/test/resources/conf.properties");
    }


    @Inject
    @Named("db.dataSource")
    DataSource dataSource;

    @Test
    public void TestDataSource() throws SQLException {
        Assertions.assertNotNull(dataSource);
        Connection connection = dataSource.getConnection();
        System.out.println(connection.getSchema());
        System.out.println("Database is ready to use....");
        connection.close();
    }
}
