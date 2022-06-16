package tests;

import datamodel.Contact;
import org.hibernate.internal.build.AllowSysOut;
import org.junit.*;
import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
import services.data.ContactCsvDAO;
import services.exceptions.UnableToLoadContactsException;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


public class TestJUN2 {

    public static List<Contact> contactList = new ArrayList<>();
    public static ContactCsvDAO contactCsvDAO;

    @BeforeClass
    public static void openFile() throws URISyntaxException {
        String rawStringList = TestMVN2.class.getResource("/17-contacts.csv").toURI().getPath();
        contactCsvDAO = new ContactCsvDAO(rawStringList);
    }

    @Before
    public void readFile() throws UnableToLoadContactsException {
        contactList = contactCsvDAO.readAll();
    }

    @After
    public void getFromFile() {
        for (int i = 0; i < contactList.size(); i++) {
            System.out.println(contactList.get(i).getFirstName() + " " + contactList.get(i).getLastName());
        }
    }

    @AfterClass
    public static void destroyFile() {
        contactList.clear();
    }

    @Test
    public void TestJune2Test() {
    }
}
