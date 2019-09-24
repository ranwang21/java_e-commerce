/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

/**
 *
 * @author rwang
 */
public class Livre {

    private int id;
    private String nom;
    private int page;
    private double prix;
    private String imageUrl;
    private int idCategory;
    private String description;

    public Livre() {
    }

    public Livre(int id, String nom, int page, double prix, String imageUrl, int idCategory, String description) {
        this.id = id;
        this.nom = nom;
        this.page = page;
        this.prix = prix;
        this.imageUrl = imageUrl;
        this.idCategory = idCategory;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

}
