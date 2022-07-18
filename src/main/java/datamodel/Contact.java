package datamodel;

import java.util.Objects;

public class Contact {

    private String firstName;
    private String lastName;
    private String state;
    private String phone1;
    private String phone;
    private String email;
    private String address;


    public Contact(String firstName, String lastName,String phone1, String phone, String email, String state, String address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone1 = phone1;
        this.phone = phone;
        this.state = state;
        this.email = email;
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(firstName, contact.firstName) && Objects.equals(lastName, contact.lastName) && Objects.equals(state, contact.state) && Objects.equals(phone1, contact.phone1) && Objects.equals(phone, contact.phone) && Objects.equals(email, contact.email) && Objects.equals(address, contact.address);
    }


    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, state, phone1, phone, email, address);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", state='" + state + '\'' +
                ", phone1='" + phone1 + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
