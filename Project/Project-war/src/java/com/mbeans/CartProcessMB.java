package com.mbeans;

import com.entities.Products;

import com.sessionbeans.ProductsFacadeLocal;
import javax.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

@Named(value = "cartProcessMB")
@RequestScoped
public class CartProcessMB implements Serializable {

    @EJB
    private ProductsFacadeLocal productsFacade;

    private int quantity = 1;    
    private static Map<Products, Integer> cartMap = new HashMap<>();

    public CartProcessMB() {
    }

    public String addCart1(int idPro) {
        Products pro = productsFacade.find(idPro);
        if (cartMap.containsKey(pro)) {
            cartMap.replace(pro, quantity);
        } else {            
            cartMap.put(pro, quantity);
        }
        return "shop";
    }

    public String increaseCart(int idPro, int newquantity) {
        Products pro = productsFacade.find(idPro);
        cartMap.replace(pro, newquantity);
        return "cart";
    }

    public String decreaseCart(int idPro, int newquantity) {
        Products pro = productsFacade.find(idPro);
        cartMap.replace(pro, newquantity);
        return "cart";
    }
    
    public double sumCart(){
        double sum = 0;
        for(Map.Entry<Products, Integer> e : cartMap.entrySet()){
            sum += e.getKey().getUnitPrice().doubleValue() * e.getValue().doubleValue();           
        }
        return sum;
    }
    
    public int sumProductCart(){
        int sum = 0;
        for(Map.Entry<Products, Integer> e : cartMap.entrySet()){            
            sum+=e.getValue();
        }
        return sum;
    }
    

    public String removeItemCart(int idPro) {
        Products pro = productsFacade.find(idPro);
        cartMap.remove(pro);
        return "cart";
    }
    public String clearnCart() {
        cartMap.clear();
        quantity = 1;
        return "cart";
    }
    
    
//getter - setter

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Map<Products, Integer> getCartMap() {
        return cartMap;
    }

    public void setCartMap(Map<Products, Integer> cartMap) {
        this.cartMap = cartMap;
    }

    public ProductsFacadeLocal getProductsFacade() {
        return productsFacade;
    }

    public void setProductsFacade(ProductsFacadeLocal productsFacade) {
        this.productsFacade = productsFacade;
    }


}
