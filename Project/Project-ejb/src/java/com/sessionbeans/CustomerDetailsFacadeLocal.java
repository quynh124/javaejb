/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sessionbeans;

import com.entities.CustomerDetails;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Hp
 */
@Local
public interface CustomerDetailsFacadeLocal {

    void create(CustomerDetails customerDetails);

    void edit(CustomerDetails customerDetails);

    void remove(CustomerDetails customerDetails);

    CustomerDetails find(Object id);

    List<CustomerDetails> findAll();

    List<CustomerDetails> findRange(int[] range);

    int count();
    
}
