/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.sessionbeans;

import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;

/**
 *
 * @author Hp
 */
@Stateless
public class CartShoppingMB implements CartShoppingMBLocal {

    Map<Integer, Integer> myCart = new HashMap<>();

    @Override
    public void addCart(int id, int quantity) {
        if (myCart.containsKey(id)) {
            myCart.replace(id, myCart.get(id) + quantity);
        } else {
            myCart.put(id, quantity);
        }
    }

    @Override
    public Map<Integer, Integer> showCart() {
        return myCart;
    }

    @Override
    public int countCart() {
        return myCart.size();
    }

    @Override
    public void removeCart(int id) {
        myCart.remove(id);
    }

    @Override
    public void emptyCart() {
        myCart.clear();
    }

    @Override
    public void updateCart(int id, boolean flag, int max) {
        if (flag) {
            if (myCart.get(id) < max) {
                myCart.replace(id, myCart.get(id) + 1);
            }
        } else {
            if (myCart.get(id) > 1) {
                myCart.replace(id, myCart.get(id) - 1);
            }
        }
    }
}
