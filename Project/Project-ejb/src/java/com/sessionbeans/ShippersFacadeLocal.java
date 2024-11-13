/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sessionbeans;

import com.entities.Shippers;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Hp
 */
@Local
public interface ShippersFacadeLocal {

    void create(Shippers shippers);

    void edit(Shippers shippers);

    void remove(Shippers shippers);

    Shippers find(Object id);

    List<Shippers> findAll();

    List<Shippers> findRange(int[] range);

    int count();
    
}
