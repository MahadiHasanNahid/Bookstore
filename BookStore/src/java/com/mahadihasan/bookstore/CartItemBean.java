package com.mahadihasan.bookstore;

import java.io.Serializable;

/**
 *
 * @author MdMahadiHasan
 */
public class CartItemBean implements Serializable {

    private BookBean book;
    private int quantity;

    public CartItemBean(BookBean book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    public BookBean getBook() {
        return book;
    }

    public int getQuantity() {
        return quantity;
    }
    
    
}
