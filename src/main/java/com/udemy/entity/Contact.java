package com.udemy.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="contact")
public class Contact {

    private String firstName;
    private String lastName;
    private String telephone;
    private String city;

    public Contact() {
    }

    public Contact(String firstName, String lastName, String telephone, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.city = city;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
