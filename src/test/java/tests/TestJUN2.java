package tests;

import datamodel.Contact;
import org.junit.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import services.data.ContactCsvDAO;
import services.exceptions.UnableToLoadContactsException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


public class TestJUN2 {

    private static String filePath;

    private ContactCsvDAO contactCsvDAO;


    @BeforeAll
    public static void beforeAllTest() throws URISyntaxException {
        filePath = ContactCsvDAO.class
                .getResource("/17-contacts.csv")
                .toURI()
                .getPath();

    }

    @BeforeEach
    public void beforeEachTest() {
        //given
        this.contactCsvDAO = new ContactCsvDAO(filePath);
    }

    @Test
    public void deserializationTest() throws Exception {
        //given the file and the dao
        //when
        List<Contact> contactList = this.contactCsvDAO.readAll();
        contactCsvDAO.sort(contactList);

        Contact shouldBeFoundContact =
                new Contact("Lenna", "Paprocki", "907-385-4412", "907-921-2010","lpaprocki@hotmail.com","AK","639 Main St");

        //then
        Assertions.assertEquals(contactList.get(0), shouldBeFoundContact);
    }

    @AfterEach
    public void afterEach() {
        System.out.println("after each");
    }


    @AfterAll
    public static void afterAll() {
        System.out.println("after all");
    }


}
