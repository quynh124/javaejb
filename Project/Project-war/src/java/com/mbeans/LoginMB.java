/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mbeans;

import com.entities.Customers;
import com.sessionbeans.CustomersFacadeLocal;
import com.sessionbeans.EmployeesFacadeLocal;
import java.io.IOException;
import javax.inject.Named;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hp
 */
@Named(value = "loginMB")
@SessionScoped
public class LoginMB implements Serializable {

    @EJB
    private EmployeesFacadeLocal employeesFacade;

    @EJB
    private CustomersFacadeLocal customersFacade;

    
    private EntityManager em;
    private Customers customers;
    private String username;
    private String password;
    private int role;

    public LoginMB() {
        customers = new Customers();
    }



    public String checkLogin() {
       
        if ("admin".equals(username) && "123".equals(password)) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/Project-war/faces/admin/doc/admin.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        } else {
          
            Customers customer = customersFacade.checkUsers(username, password);
            if (customer != null) {
                try {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/Project-war/faces/index.xhtml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            } else {
                // Invalid credentials
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid credentials", "Invalid username or password"));
                return "login";
            }
        }
    }


    public String resetForm() {
        username = null;
        password = null;
        return "login";
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public CustomersFacadeLocal getCustomersFacade() {
        return customersFacade;
    }

    public void setCustomersFacade(CustomersFacadeLocal customersFacade) {
        this.customersFacade = customersFacade;
    }

    public EmployeesFacadeLocal getEmployeesFacade() {
        return employeesFacade;
    }

    public void setEmployeesFacade(EmployeesFacadeLocal employeesFacade) {
        this.employeesFacade = employeesFacade;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    private static class BCrypt {

        public BCrypt() {
        }
    }

}
