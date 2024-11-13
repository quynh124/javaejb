/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mbeans;

import com.entities.Suppliers;
import com.sessionbeans.SuppliersFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Hp
 */
@Named(value = "supplierMB")
@RequestScoped
public class SupplierMB {

    @EJB
    private SuppliersFacadeLocal suppliersFacade;
    private Suppliers supplier;

    public SupplierMB() {
        supplier = new Suppliers();
    }

    public List<Suppliers> showAllSuppliers() {
        return suppliersFacade.findAll();
    }

    public String deleteSupplier(int id) {
        suppliersFacade.remove(suppliersFacade.find(id));
        return "table-data-suppliers";
    }

    public String addSupplier() {
        System.out.println("ID :" + supplier.getSupplierID());
        if (supplier.getSupplierID() == null) {
            suppliersFacade.create(supplier);
        } else {
            suppliersFacade.edit(supplier);
        }
        return "table-data-suppliers";
    }
   public String findSupplierforUpdate(int id){
         supplier = suppliersFacade.find(id);
        return "table-data-suppliers";
    }
   
    public String resetForm(){
        supplier = null;
        return "table-data-suppliers";
    }
    
//get,set

    public SuppliersFacadeLocal getSuppliersFacade() {
        return suppliersFacade;
    }

    public void setSuppliersFacade(SuppliersFacadeLocal suppliersFacade) {
        this.suppliersFacade = suppliersFacade;
    }

    public Suppliers getSupplier() {
        return supplier;
    }

    public void setSupplier(Suppliers supplier) {
        this.supplier = supplier;
    }
}
