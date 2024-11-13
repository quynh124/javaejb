/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sessionbeans;

//import static com.sun.tools.javac.code.Symbol.ModuleFlags.value;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import static javax.management.Query.value;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.servlet.http.Part;

/**
 *
 * @author Hp
 */
@Entity
@FacesValidator(value="UplodaValidator")
public class UplodaValidator implements Validator {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UplodaValidator)) {
            return false;
        }
        UplodaValidator other = (UplodaValidator) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sessionbeans.UplodaValidator[ id=" + id + " ]";
    }

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static class FacesMessege {

        public FacesMessege() {
        }
    }
//     @Override
//    public class validate(FacesContext fc, UIComponent uic, Object value)
//    throws ValidatorException{
//        Part p = (Part) value;
//        //ảnh phải là png hoạc jpg
//        if(!p.getContentType().equals("image/png")&&
//        !p.getContextType().equals("image/jpg")){
//            FacesMessege msg = new FacesMessage("Need png/jpg");
//            throw new ValidatorException(msg);
//        }
//        if (p.getSize()> 2097152){
//            FacesMessege msg = new FacesMessage("Size <= 2MB");
//            throw new ValidatorException(msg);
//        }
//    }    
    
}
