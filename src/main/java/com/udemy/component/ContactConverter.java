package com.udemy.component;

import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;
import org.springframework.stereotype.Component;

@Component("contactConverter")
public class ContactConverter {

    public Contact convertContactModelToContact(ContactModel contactModel){
        Contact contact = new Contact();
        contact.setFirstName(contactModel.getFirstName());
        contact.setLastName(contactModel.getLastName());
        contact.setTelephone(contactModel.getTelephone());
        contact.setCity(contactModel.getCity());
        contact.setId(contactModel.getId());
        return contact;

    }

    public ContactModel convertContactToContactModel(Contact contact){
        ContactModel contactModel = new ContactModel();
        contactModel.setId(contact.getId());
        contactModel.setFirstName(contact.getFirstName());
        contactModel.setLastName(contact.getLastName());
        contactModel.setTelephone(contact.getTelephone());
        contactModel.setCity(contact.getCity());
        return contactModel;
    }

}
