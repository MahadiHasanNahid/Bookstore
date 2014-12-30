package com.mahadihasan.bookstore;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author MdMahadiHasan
 */
public class BookBean implements Serializable {
    
    private String ISBN;
    private String title;
    private String copyright;
    private String imageFile;
    private int editionNumber;
    private int publisherId;
    private double price;

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    public void setEditionNumber(int editionNumber) {
        this.editionNumber = editionNumber;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getImageFile() {
        return imageFile;
    }

    public int getEditionNumber() {
        return editionNumber;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public double getPrice() {
        return price;
    }
    
    
    public Element getXML(Document document) {
        Element product = document.createElement("product");
        Element temp = document.createElement("isbn");
        temp.appendChild(document.createTextNode(getISBN()));
        product.appendChild(temp);
        
        
        NumberFormat priceFormatter = 
                NumberFormat.getCurrencyInstance(Locale.US);
        
        temp = document.createElement("price");
        temp.appendChild(document.createTextNode(priceFormatter.format(getPrice())));
        product.appendChild(temp);
        
        temp = document.createElement("imageFile");
        temp.appendChild(document.createTextNode(getImageFile()));
        product.appendChild(temp);
        
        temp = document.createElement("copyright");
        temp.appendChild(document.createTextNode(getCopyright()));
        product.appendChild(temp);
        
        temp = document.createElement("publisherID");
        temp.appendChild(document.createTextNode(String.valueOf(getPublisherId())));
        product.appendChild(temp);
        
        
        temp = document.createElement("editionNumber");
        temp.appendChild(document.createTextNode(String.valueOf(getEditionNumber())));
        product.appendChild(temp);
        
        
        return product;
    }
}
