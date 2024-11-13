/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package com.sessionbeans;

import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author Hp
 */
@Local
public interface CartShoppingMBLocal {
    
     public void addCart(int id, int quantity);

    public Map<Integer, Integer> showCart();

    public int countCart();

    public void emptyCart();

    public void removeCart(int id);

    public void updateCart(int id, boolean flag, int max);
}
