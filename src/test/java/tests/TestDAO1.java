package tests;

import conf.AppConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
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

    static {
        System.setProperty("conf.file", "src/test/resources/conf.properties");
    }

    @Inject
    @Named("db.dataSource")
    DataSource dataSource;


    private ContactJDBCDAO contactJDBCDAO;

    @Test
    public void test() throws SQLException {


        contactJDBCDAO = new ContactJDBCDAO();
        Assertions.assertNotNull(dataSource);
        contactJDBCDAO.setConnection(dataSource.getConnection());
        contactJDBCDAO.setDataSource(dataSource);

        contactJDBCDAO.create();
        contactJDBCDAO.search();

    }

}
