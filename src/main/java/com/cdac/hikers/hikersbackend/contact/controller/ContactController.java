package com.cdac.hikers.hikersbackend.contact.controller;

import com.cdac.hikers.hikersbackend.contact.entities.Contact;
import com.cdac.hikers.hikersbackend.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ContactController {
    @Autowired
    private ContactService contactService;
    @PostMapping("/contactus")
    public String saveContact(@RequestBody Contact contact){
        return contactService.setContact(contact);
    }
    @PostMapping("/saveallcontact")
    public List<Contact> saveAllData(@RequestBody List<Contact> contacts){
        return contactService.setAllContact(contacts);
    }
    @GetMapping("/getbyid/{id}")
    public Contact getById(@PathVariable int id){
        return contactService.findById(id);
    }
    @GetMapping("/getalldata")
    public List<Contact> getAllData(){
        return contactService.findAllData();
    }
    @DeleteMapping("/deletedatabyid/{id}")
    public String deleteDataById(@PathVariable int id){
        contactService.deleteById(id);
        return "removed data!!";
    }
    @PutMapping("/updateinformation")
    public Contact updateData(Contact contact){
        return contactService.updateContact(contact);
    }
}
