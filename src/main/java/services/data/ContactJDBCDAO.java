package services.data;

import conf.AppConfiguration;
import datamodel.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import services.database.Configuration;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfiguration.class})

public class ContactJDBCDAO {

    static {
        System.setProperty("conf.file", "src/test/resources/conf.properties");
    }

    @Inject
    @Named("db.dataSource")
    DataSource dataSource;

//    @BeforeEach
//    public void create() throws SQLException {
//        // TO create a table in in-memory database
//        Assertions.assertNotNull(dataSource);
//        Connection connection = dataSource.getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS contact (firstName VARCHAR(255), lastName VARCHAR(255), phone1 VARCHAR(255), phone VARCHAR(255), email VARCHAR(255), state VARCHAR(255))");
//        preparedStatement.execute();
//    }

    public void search() throws SQLException {
        Contact contact = new Contact("Anshul", "Rana", "12345", "54321", "anshul@gmail.com","KTM");


        //when
        ContactDAO dao = new ContactDAO(dataSource);
        dao.insert(contact);


        //then
        Connection connection =  dataSource.getConnection();
        ResultSet resultSet = connection.prepareStatement("select * from contact where firstName = 'Anshul'").executeQuery();
        String retrievedName = null;
        while (resultSet.next()) {
            retrievedName = resultSet.getString("firstName");
        }
        Assertions.assertNotNull(retrievedName);
    }
}
