package services.data;

import datamodel.Contact;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactDAO {

    DataSource dataSource;

    public ContactDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insert(Contact contact) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO contact ( firstName, lastName, phone1, phone, email, state ) VALUES ( ?, ?, ?, ?, ?, ?)");

            //should be set manually
            preparedStatement.setString(1, contact.getFirstName());
            preparedStatement.setString(2, contact.getLastName());
            preparedStatement.setString(3, contact.getPhone1());
            preparedStatement.setString(4, contact.getPhone());
            preparedStatement.setString(5, contact.getEmail());
            preparedStatement.setString(6, contact.getState());

            preparedStatement.execute();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
