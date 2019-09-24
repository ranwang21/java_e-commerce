/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.util.Set;

/**
 *
 * @author fgaudrea
 */
public class Commande {
    
    private int id;
    private int idUser;
    private String date;
    private float total;
 
    private Set<CommandeWrapper> orderItems;

  
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Set<CommandeWrapper> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<CommandeWrapper> orderItems) {
		this.orderItems = orderItems;
	}

    
    
}
