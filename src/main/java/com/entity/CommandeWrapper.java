/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

/**
 *
 * @author fgaudrea
 */
public class CommandeWrapper {
    
    private int idCommande;
    private int idLivre;
    
    
    private int qty;
    private Double subtotal;
    
    private Livre livre;
    
    

    public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(int idLivre) {
        this.idLivre = idLivre;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public CommandeWrapper(int idCommande, int idLivre, int qty) {
        this.idCommande = idCommande;
        this.idLivre = idLivre;
        this.qty = qty;
    }

    public CommandeWrapper() {
    }
    
}
