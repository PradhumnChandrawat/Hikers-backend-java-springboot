package com.cdac.hikers.hikersbackend.contact.service;

import com.cdac.hikers.hikersbackend.contact.entities.Contact;
import com.cdac.hikers.hikersbackend.contact.repository.ContactRepository;
import com.cdac.hikers.hikersbackend.util.userValidation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserValidation userValidation;

    public String setContact(Contact contact) {
        try {
            contactRepository.save(contact);
            return "Your request has been saved, we'll contact you shortly.";
        } catch (Exception ex) {
            return "Error occured, please try again";
        }
    }

    public List<Contact> setAllContact(List<Contact> contacts) {
        return contactRepository.saveAll(contacts);
    }

    public Contact findById(int id) {
        return contactRepository.findById(id).orElse(null);
    }

    public List<Contact> findAllData() {
        return contactRepository.findAll();
    }

    public String deleteById(int id) {
        if (contactRepository.existsById(id)) {
            contactRepository.deleteById(id);
            return "removed data!!" + id;
        } else {
            return "not found";
        }
    }

    public Contact updateContact(Contact contact) {
        Contact existingContact = contactRepository.findById(contact.getId()).orElse(null);
        if (contact.getName() != null) existingContact.setName(contact.getName());
        if (contact.getEmail() != null) existingContact.setEmail(contact.getEmail());
        if (contact.getPhone() != null) existingContact.setPhone(contact.getPhone());
        if (contact.getMessage() != null) existingContact.setMessage(contact.getMessage());
        return (existingContact);
    }
}
