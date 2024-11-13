/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mbeans;

import com.entities.Contact;
import com.sessionbeans.ContactFacadeLocal;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.jms.Connection;

/**
 *
 * @author Hp
 */
@Named(value = "contactMB")
@RequestScoped
public class ContactMB {

    private String name;
    private String email;
    private String message;
    @EJB
    private ContactFacadeLocal contactFacade;

    private Contact contact;

    public ContactMB() {
        contact = new Contact();
    }

    public List<Contact> showAllContact() {
        return contactFacade.findAll();
    }
    public String submit() {
      
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Message: " + message);

   
        return "contacts";
    }

    public String addContact() {
  System.out.println("ID :"+contact.getName());
       if(contact.getName()==null){
           contactFacade.create(contact);
       }else{
        contactFacade.edit(contact);
    }
        return "table-data-table";
    }
    

    public String deleteContact(int id) {
        contactFacade.remove(contactFacade.find(id));
        return "table-data-table";
    }

    public String resetForm() {
        contact = null;
        return "table-data-table";
    }

    public String findContactbyID(int id) {
        contact = contactFacade.find(id);
        return "table-data-table";
    }

    public ContactFacadeLocal getContactFacade() {
        return contactFacade;
    }

    public void setContactFacade(ContactFacadeLocal contactFacade) {
        this.contactFacade = contactFacade;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
