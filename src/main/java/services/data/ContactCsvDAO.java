package services.data;

import datamodel.Contact;
import services.exceptions.UnableToLoadContactsException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContactCsvDAO {

    public String rawStringList;
    public String filePath = "./src/test/resources/17-contacts.csv";


    public ContactCsvDAO(String path) {
        filePath = path;
    }


    public List<Contact> readAll() throws UnableToLoadContactsException {

        File file = new File(this.filePath);

        List<String> rawStringList = null;
        try {
            rawStringList = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            System.out.println("Technical problem. Not able to locate the file");
            throw new UnableToLoadContactsException(e);
        }

        //Remove the header line
        rawStringList.remove(0);

        List<Contact> contactList = new ArrayList<>();

        for (String row : rawStringList) {
            String[] parts = row.split(",");
            String firstName = parts[0];
            String lastName = parts[1];
            String phone1 = parts[8];
            String phone = parts[9];
            String email = parts[10];
            String state = parts[6];
            String address = parts[3];

            //only 5 field out of 11 are mapped

            Contact contact = new Contact(firstName, lastName, phone1, phone, email, state, address);
            contactList.add(contact);

        }
        return contactList;
    }

    public void sort(List<Contact> contactList) {
//        Collections.sort(contactList, new Comparator<Contact>() {
//            @Override
//            public int compare(Contact o1, Contact o2) {
//                return o1.getState().compareTo(o2.getState());
//            }
//        });

        Collections.sort(contactList, (contact1, contact2) -> {
            return contact1.getState().compareTo(contact2.getState());
        });

//        Collections.sort(contactList, Comparator.comparing(Contact::getState, (state1, state2) -> state2.compareTo(state1)));
    }
}
