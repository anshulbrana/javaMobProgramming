package tests;

import datamodel.Contact;
import org.junit.*;
import org.junit.jupiter.api.DisplayName;
import services.data.ContactCsvDAO;
import services.exceptions.UnableToLoadContactsException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


public class TestJUN2 {

    public static List<Contact> contactList = new ArrayList<>();
    public static ContactCsvDAO contactCsvDAO;
    public static ArrayList<String> firstNameList = new ArrayList<>();

    @BeforeClass
    public static void openFile() throws URISyntaxException {
        String rawStringList = TestMVN2.class.getResource("/17-contacts.csv").toURI().getPath();
        contactCsvDAO = new ContactCsvDAO(rawStringList);
    }

    @Before
    public void readFile() throws UnableToLoadContactsException {
        contactList = contactCsvDAO.readAll();
            for (int i = 0; i < contactList.size(); i++) {
                firstNameList.add(contactList.get(i).getFirstName());
            }

    }

    @After
    public void getFromFile() {
        System.out.println(firstNameList);

    }

    @AfterClass
    public static void destroyFile() {
        contactList.clear();
    }

    @Test
    @DisplayName("Before, BeforeClass, After, AfterClass that manages instance from the class that does the deserialization")
    public void TestJune2Test() throws Exception {

    }
}
