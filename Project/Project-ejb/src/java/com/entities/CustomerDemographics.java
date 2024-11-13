/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hp
 */
@Entity
@Table(name = "CustomerDemographics")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerDemographics.findAll", query = "SELECT c FROM CustomerDemographics c"),
    @NamedQuery(name = "CustomerDemographics.findByCustomerTypeID", query = "SELECT c FROM CustomerDemographics c WHERE c.customerTypeID = :customerTypeID"),
    @NamedQuery(name = "CustomerDemographics.findByCustomerDesc", query = "SELECT c FROM CustomerDemographics c WHERE c.customerDesc = :customerDesc")})
public class CustomerDemographics implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CustomerTypeID")
    private String customerTypeID;
    @Size(max = 1073741823)
    @Column(name = "CustomerDesc")
    private String customerDesc;

    public CustomerDemographics() {
    }

    public CustomerDemographics(String customerTypeID) {
        this.customerTypeID = customerTypeID;
    }

    public String getCustomerTypeID() {
        return customerTypeID;
    }

    public void setCustomerTypeID(String customerTypeID) {
        this.customerTypeID = customerTypeID;
    }

    public String getCustomerDesc() {
        return customerDesc;
    }

    public void setCustomerDesc(String customerDesc) {
        this.customerDesc = customerDesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerTypeID != null ? customerTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerDemographics)) {
            return false;
        }
        CustomerDemographics other = (CustomerDemographics) object;
        if ((this.customerTypeID == null && other.customerTypeID != null) || (this.customerTypeID != null && !this.customerTypeID.equals(other.customerTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.CustomerDemographics[ customerTypeID=" + customerTypeID + " ]";
    }
    
}
