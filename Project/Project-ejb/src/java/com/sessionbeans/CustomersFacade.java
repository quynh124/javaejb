/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sessionbeans;

import com.entities.Categories;
import com.entities.Customers;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Hp
 */
@Stateless
public class CustomersFacade extends AbstractFacade<Customers> implements CustomersFacadeLocal {

    @PersistenceContext(unitName = "Project-ejbPU")
    private EntityManager em;
    private Object password;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomersFacade() {
        super(Customers.class);
    }

    public Customers checkCustomer(String uname, String pword) {
        boolean flag = false;
        String sql = "SELECT c FROM Customers c WHERE c.customerID = :username and c.password = :password";
        Query query = em.createQuery(sql);
        query.setParameter("username", uname);
        query.setParameter("password", pword);
        try {
            return (Customers) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }


    @Override
    public Customers checkUsers(String uname, String pword) {

        String sql = "SELECT u FROM Customers  u WHERE u.username = :username and u.password = :password";
        Query query = em.createQuery(sql);
        query.setParameter("username", uname);
        query.setParameter("password", pword);
        try {
            return (Customers) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }


    @Override
    public Customers checkCustomers(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
      @Override
    public List<Customers> findByCustomersDescriptionSame(String key) {
        Query query = em.createQuery("SELECT c FROM Customers c WHERE c.username like :keydes", Customers.class);        
        query.setParameter("keydes", "%"+key+"%");
        return query.getResultList();
    }

}
