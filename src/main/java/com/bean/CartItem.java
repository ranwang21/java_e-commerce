package com.bean;

import com.entity.Livre;

/**
 * @author rwang
 *
 */
public class CartItem {

    private Livre livre;
    private Double price = 0.0;
    private int count;
    private Double subtotal;

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    /**
     * get subtotal = price * count
     *
     * @return
     */
    public double getSubtotal() {
        return count * getPrice();
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

}
