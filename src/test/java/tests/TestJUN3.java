package tests;

import datamodel.Contact;
import services.data.ContactCsvDAO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestJUN3 {

    public static void main(String[] args) throws Exception {

        //Given
        String rawStringList = TestMVN2.class.getResource("/17-contacts.csv").toURI().getPath();
        ContactCsvDAO contactCsvDAO = new ContactCsvDAO(rawStringList);
        ArrayList<String> firstNameList = new ArrayList<>();


        //When
        List<Contact> contactList = contactCsvDAO.readAll();
        for (int i = 0; i < contactList.size(); i++) {
            firstNameList.add(contactList.get(i).getFirstName());
        }
        ArrayList<String> checkFirstNameList = new ArrayList<>(Arrays.asList("Lenna", "Donette", "Mitsue", "Leota", "Sage", "Abel", "Kiley", "Graciela", "Mattie", "Gladys", "Yuki", "Fletcher", "Bette", "Veronika", "Willard", "Maryann", "Alisha"));

//        System.out.println(checkFirstNameList);
//        System.out.println(firstNameList);
        //Then
        for (int i = 0; i < checkFirstNameList.size(); i++) {
            if (!(firstNameList.get(i).equals(checkFirstNameList.get(i)))) {
                throw new Exception("Check not passed for TestJUN3");
            }
        }


    }


}
