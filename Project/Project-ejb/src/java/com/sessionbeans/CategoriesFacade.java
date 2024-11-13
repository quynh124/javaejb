/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sessionbeans;

import com.entities.Categories;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Hp
 */
@Stateless
public class CategoriesFacade extends AbstractFacade<Categories> implements CategoriesFacadeLocal {

    @PersistenceContext(unitName = "Project-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriesFacade() {
        super(Categories.class);
    }
     @Override
    public List<Categories> findByCategoriesDescriptionSame(String key) {
        Query query = em.createQuery("SELECT c FROM Categories c WHERE c.categoryName like :keydes", Categories.class);        
        query.setParameter("keydes", "%"+key+"%");
        return query.getResultList();
    }
    @Override
    public List<Categories> findByCategoriesDescriptionExact(String des) {
        Query query = em.createNamedQuery("Categories.findByCategoryName", Categories.class);
        query.setParameter("categoryName", des);
        return query.getResultList();
    }
}
