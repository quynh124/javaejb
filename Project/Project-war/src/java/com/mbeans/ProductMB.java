/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mbeans;

import com.entities.Products;
import com.sessionbeans.CategoriesFacadeLocal;
import com.sessionbeans.ProductsFacadeLocal;
import com.sessionbeans.SuppliersFacadeLocal;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

/**
 *
 * @author Hp
 */
@Named(value = "productMB")
@RequestScoped
public class ProductMB {

    @EJB
    private SuppliersFacadeLocal suppliersFacade;

    @EJB
    private CategoriesFacadeLocal categoriesFacade;

    @EJB
    private ProductsFacadeLocal productsFacade;

    private Products product;
    private int supplierID;
    private int productID;

    private int categoryID;
    private String image;
    private Part images;
    private List<Products> listProduct;
     private String keyfind;


    public ProductMB() {
        product = new Products();
    }

   

    public String findProductbyID(int id) {
        product = productsFacade.find(id);
        return "table-data-product";
    }

    public String deletePro(int id) {
        productsFacade.remove(productsFacade.find(id));
        return "table-data-product";
    }


    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        for (String cd : contentDisposition.split(";")) {
            if (cd.trim().startsWith("filename")) {
                return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }


    public String addProducts() {
        try {
            if (images != null) {
        
                String uploadDirectory = "";
                String fileName = getFileName(images);
                String filePath = uploadDirectory + "/" + fileName;

         
                try (InputStream input = images.getInputStream()) {
                    Path destination = Paths.get(uploadDirectory, fileName);
                    Files.copy(input, destination, StandardCopyOption.REPLACE_EXISTING);
                }

            
                product.setImages(filePath);

            }
            if (product.getProductID() == null) {
                product.setCategoryID(categoriesFacade.find(categoryID));
                product.setSupplierID(suppliersFacade.find(supplierID));
                productsFacade.create(product);
            } else {
                product.setCategoryID(categoriesFacade.find(categoryID));
                product.setSupplierID(suppliersFacade.find(supplierID));
                productsFacade.edit(product);
            }
        } catch (IOException e) {

            e.printStackTrace();
        }

        return "table-data-product";
    }

    public String deleteProducts(String productID) {
        Products productsToDelete = productsFacade.find(productID);
        if (productsToDelete != null) {
         
            deleteImage(productsToDelete.getImages());

         
            productsFacade.remove(productsToDelete);

       
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(""));
        } else {
  
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(""));
        }
        return "table-data-product";
    }

       public String findByProductsDescriptionSame() {
        listProduct= productsFacade. findByProductsDescriptionSame(keyfind);
        return "table-data-product";
    }

    public String findProductforUpdate(Products pro) {
        product = pro;
        return "table-data-product";
    }

    public List<Products> showAllProducts() {
        return productsFacade.findAll();
    }

    public String resetForm() {
        product = null;
        return "table-data-product";
    }

    public void handleFileUpload(FileUploadEvent event) {
        UploadedFile uploadedFile = event.getFile();
        String fileName = uploadedFile.getFileName();
        String contentType = uploadedFile.getContentType();
        byte[] contents = uploadedFile.getContents();

        // Save the file to a location
        String destination = "/path/to/your/upload/directory/" + fileName;
        try (OutputStream outputStream = new FileOutputStream(new File(destination))) {
            outputStream.write(contents);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    //get,set
    public ProductsFacadeLocal getProductsFacade() {
        return productsFacade;
    }

    public void setProductsFacade(ProductsFacadeLocal productsFacade) {
        this.productsFacade = productsFacade;
    }

    public SuppliersFacadeLocal getSuppliersFacade() {
        return suppliersFacade;
    }

    public void setSuppliersFacade(SuppliersFacadeLocal suppliersFacade) {
        this.suppliersFacade = suppliersFacade;
    }

    public CategoriesFacadeLocal getCategoriesFacade() {
        return categoriesFacade;
    }

    public void setCategoriesFacade(CategoriesFacadeLocal categoriesFacade) {
        this.categoriesFacade = categoriesFacade;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

 

    
  

    private void deleteImage(String images) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Part getImages() {
        return images;
    }

    public void setImages(Part images) {
        this.images = images;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public List<Products> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Products> listProduct) {
        this.listProduct = listProduct;
    }

    public String getKeyfind() {
        return keyfind;
    }

    public void setKeyfind(String keyfind) {
        this.keyfind = keyfind;
    }

  

//    private void deleteImages(String images) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

    private static class FaceContext {

        private static Object getCurenInstance() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public FaceContext() {
        }
    }

    private static class FileUploadEvent {

        public FileUploadEvent() {
        }

        private UploadedFile getFile() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }

    private static class UploadedFile {

        public UploadedFile() {
        }

        private String getFileName() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private byte[] getContents() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private String getContentType() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private InputStream getInputstream() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
     public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
