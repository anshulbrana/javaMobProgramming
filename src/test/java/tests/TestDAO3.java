package tests;

import conf.AppConfiguration;
import datamodel.Contact;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import services.data.ContactCsvDAO;
import services.data.ContactDAO;
import services.data.ContactJDBCDAO;
import services.exceptions.UnableToLoadContactsException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfiguration.class})

public class TestDAO3 {

    static {
        System.setProperty("conf.file", "src/test/resources/conf.properties");
    }

    @Inject
    @Named("db.dataSource")
    DataSource dataSource;

    private ContactJDBCDAO contactJDBCDAO;
    public static ContactCsvDAO contactCsvDAO;
    public static List<Contact> contactList = new ArrayList<>();

    @Test
    public void test() throws SQLException, UnableToLoadContactsException, URISyntaxException {
        contactJDBCDAO = new ContactJDBCDAO();
        Assertions.assertNotNull(dataSource);
        contactJDBCDAO.setConnection(dataSource.getConnection());
        contactJDBCDAO.setDataSource(dataSource);

        //Get connection

        ContactDAO contactDAO = new ContactDAO(dataSource);

        //Get data from file

        String rawStringList = TestMVN2.class.getResource("/17-contacts.csv").toURI().getPath();
        contactCsvDAO = new ContactCsvDAO(rawStringList);
        contactList = contactCsvDAO.readAll();

        //Create connection

        contactJDBCDAO.create();
        Connection connection = dataSource.getConnection();

        for (int i = 0; i < contactList.size(); i++) {
            contactDAO.insert(contactList.get(i));
        }

        //Write query to test if data is inserted or not
        ResultSet resultSet = connection.prepareStatement("select * from contact").executeQuery();

        //Create array list for checking firstname from database
        ArrayList<String> firstNameList = new ArrayList<>();

        System.out.println(resultSet);
        while (resultSet.next()) {
            firstNameList.add(resultSet.getString("firstName"));
        }
        System.out.println(firstNameList);


    }
}
