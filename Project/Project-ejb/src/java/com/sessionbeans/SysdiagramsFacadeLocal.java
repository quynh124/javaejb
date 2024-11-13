/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sessionbeans;

import com.entities.Sysdiagrams;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Hp
 */
@Local
public interface SysdiagramsFacadeLocal {

    void create(Sysdiagrams sysdiagrams);

    void edit(Sysdiagrams sysdiagrams);

    void remove(Sysdiagrams sysdiagrams);

    Sysdiagrams find(Object id);

    List<Sysdiagrams> findAll();

    List<Sysdiagrams> findRange(int[] range);

    int count();
    
}
