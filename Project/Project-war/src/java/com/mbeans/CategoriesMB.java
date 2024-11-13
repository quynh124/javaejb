/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mbeans;

import com.entities.Categories;
import com.sessionbeans.CategoriesFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Hp
 */
@Named(value = "categoriesMB")
@RequestScoped
public class CategoriesMB {

    @EJB
    private CategoriesFacadeLocal categoriesFacade;

    private Categories categories;
    private String keyfind;
    private List<Categories> listCategories;

    private Categories category;
    
    public CategoriesMB() {
         category = new Categories();
         listCategories = new ArrayList<>();
    }
    
    
    public String addCategories(){
        System.out.println("ID :"+category.getCategoryID());
       if(category.getCategoryID()==null){
           categoriesFacade.create(category);
       }else{
        categoriesFacade.edit(category);
    }
        return "table-data-table-catetory";
    }
     public String deleteCategories(int id){
         categoriesFacade.remove(categoriesFacade.find(id));
        return "table-data-table-catetory";
    }

       public String findCategorybyID(int id){
         category = categoriesFacade.find(id);
        return "table-data-table-catetory";
    }
       
       public String findCategoriesDescriptionExact() {
        listCategories =  categoriesFacade.findByCategoriesDescriptionExact(keyfind);
        return "table-data-table-catetory";
    }
    
    public String findCategoriesDescriptionSame() {
        listCategories =  categoriesFacade.findByCategoriesDescriptionSame(keyfind);
        return "table-data-table-catetory";
    }
    
    
    public List<Categories> showAllCategories(){
        return categoriesFacade.findAll();
    }
    public String resetForm(){
        category = null;
        return "table-data-table-catetory";
    }
//get/ set
    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public String getKeyfind() {
        return keyfind;
    }

    public void setKeyfind(String keyfind) {
        this.keyfind = keyfind;
    }

    public List<Categories> getListCategories() {
        return listCategories;
    }

    public void setListCategories(List<Categories> listCategories) {
        this.listCategories = listCategories;
    }

    public CategoriesFacadeLocal getCategoriesFacade() {
        return categoriesFacade;
    }

    public void setCategoriesFacade(CategoriesFacadeLocal categoriesFacade) {
        this.categoriesFacade = categoriesFacade;
    }
}
