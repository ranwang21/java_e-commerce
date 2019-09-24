/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

/**
 *
 * @author morellan
 */
public class LivrePanierWrapper {

    private Livre livre;
    private int qty;

    public LivrePanierWrapper(Livre livre, int qty) {

        this.livre = livre;
        this.qty = qty;
    }

    public LivrePanierWrapper() {
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

}
