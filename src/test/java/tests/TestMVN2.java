package tests;

import datamodel.Contact;
import services.data.ContactCsvDAO;

import java.util.List;

public class TestMVN2 {

    public static void main(String[] args) throws Exception {
        //Given
        ContactCsvDAO testContactCsvDAO = new ContactCsvDAO("./src/test/resources/17-contacts.csv");

        // when
        List<Contact> contactList = testContactCsvDAO.readAll();
        testContactCsvDAO.sort(contactList);

        //then
        if(!(contactList.get(0).getEmail().equals("lpaprocki@hotmail.com"))){
            throw new Exception("Check not passed for TestMVN2");
        }
    }

}
