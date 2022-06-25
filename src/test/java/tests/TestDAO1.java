package tests;

import conf.AppConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import services.data.ContactJDBCDAO;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfiguration.class})

public class TestDAO1 {

//    static {
//        System.setProperty("conf.file", "src/test/resources/conf.properties");
//    }
//
//    @Inject
//    @Named("db.dataSource")
//    DataSource dataSource;
//
//    @BeforeEach
//    public void create() throws SQLException {
//        // TO create a table in in-memory database
//        Assertions.assertNotNull(dataSource);
//        Connection connection = dataSource.getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS contact (firstName VARCHAR(255), lastName VARCHAR(255), phone1 VARCHAR(255), phone VARCHAR(255), email VARCHAR(255), state VARCHAR(255))");
//        preparedStatement.execute();
//    }


    @Test
    public void test() throws SQLException {

        ContactJDBCDAO contactJDBCDAO = new ContactJDBCDAO();
//        contactJDBCDAO.create();
        contactJDBCDAO.search();

    }

}
