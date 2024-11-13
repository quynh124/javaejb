/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sessionbeans;

import com.entities.CustomerDemographics;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Hp
 */
@Local
public interface CustomerDemographicsFacadeLocal {

    void create(CustomerDemographics customerDemographics);

    void edit(CustomerDemographics customerDemographics);

    void remove(CustomerDemographics customerDemographics);

    CustomerDemographics find(Object id);

    List<CustomerDemographics> findAll();

    List<CustomerDemographics> findRange(int[] range);

    int count();
    
}
