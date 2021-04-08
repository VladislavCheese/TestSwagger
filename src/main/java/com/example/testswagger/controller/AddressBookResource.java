package com.example.testswagger.controller;

import com.example.testswagger.dto.Contact;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
@RequestMapping("/api")
public class AddressBookResource {

    ConcurrentMap<String, Contact> contacts = new ConcurrentHashMap<>();

    @ApiOperation(value = "Get contact by id",
    notes = "More information",
    response = Contact.class)
    @GetMapping("/{id}")
    public Contact getContact(@ApiParam(value = "description", required = true)
                                  @PathVariable String id){
        return contacts.get(id);
    }
    @GetMapping("/")
    public List<Contact> getAllContacts(){
        return new ArrayList<>(contacts.values());
    }
    @PostMapping("/")
    public Contact addContact(@RequestBody Contact contact){
        contacts.put(contact.getId(),contact);
        return contact;
    }
}
