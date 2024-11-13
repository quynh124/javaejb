/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mbeans;

import com.entities.Customers;

import com.sessionbeans.CustomersFacadeLocal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Hp
 */
@Named(value = "customerMB")
@RequestScoped
public class CustomerMB {

    @EJB
    private CustomersFacadeLocal customersFacade;

    private Customers customer;
    private String username;
    private String password;
     private List<Customers> listCustomer;
     private String keyfind;

    public CustomerMB() {
        customer = new Customers();
         listCustomer = new ArrayList<>();

    }

    public String addCustomer() {
        customersFacade.create(customer);
        return "login";
    }
     public String addCustomers() {
        customersFacade.create(customer);
        return "table-data-customer";
    }

    public String resetForm() {
        customer = null;
        return "register";
    }

    public List<Customers> showAllCustomer() {
        return customersFacade.findAll();
    }


    public String findCustomerbyID(int id) {
        customer = customersFacade.find(id);
        return "table-data-customer";
    }

    public String deleteCustomer(int id) {
        customersFacade.remove(customersFacade.find(id));
        return "table-data-customer";
    }
      public String findByCustomersDescriptionSame() {
        listCustomer= customersFacade. findByCustomersDescriptionSame(keyfind);
        return "table-data-customer";
    }
//get set

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public CustomersFacadeLocal getCustomersFacade() {
        return customersFacade;
    }

    public void setCustomersFacade(CustomersFacadeLocal customersFacade) {
        this.customersFacade = customersFacade;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Customers> getListCustomer() {
        return listCustomer;
    }

    public void setListCustomer(List<Customers> listCustomer) {
        this.listCustomer = listCustomer;
    }

    public String getKeyfind() {
        return keyfind;
    }

    public void setKeyfind(String keyfind) {
        this.keyfind = keyfind;
    }

}
