/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mbeans;


import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named(value = "cartShoppingMB")
@SessionScoped
public class CartShoppingMB implements Serializable {

    List<Integer> numCart = new ArrayList<>();

    public CartShoppingMB() {
    }
    


}
