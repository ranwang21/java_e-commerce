/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.entity.Category;
import com.manager.CategoryM;
import com.manager.LivreM;

/**
 *
 * @author fgaudrea
 */
public class LivreA {

    public static final String listLivre = "listLivre";
    public static final String listCategory = "listCategory";
    public static final String livreById = "livreById";

    public static void afficherAll(HttpServletRequest request) {
        // register list of all book into the request(jsp use it to loop books)
        request.setAttribute(listLivre, LivreM.getAll());
        // register list of categoies in the request
        ArrayList<Category> list = CategoryM.getAll();
        request.setAttribute(listCategory, list);
    }

    public static void afficherByIdCategory(HttpServletRequest request, int idCategory) {
        request.setAttribute(listLivre, LivreM.getByIdCategory(idCategory));

        ArrayList<Category> arr = CategoryM.getAll();
        System.out.println(arr);
        request.setAttribute(listCategory, arr);
    }

    public static void afficherByNbPages(HttpServletRequest request, int minPage, int maxPage) {
        request.setAttribute(listLivre, LivreM.getByNbPages(minPage, maxPage));
        ArrayList<Category> arr = CategoryM.getAll();
        System.out.println(arr);
        request.setAttribute(listCategory, arr);
    }

    public static void afficherByName(HttpServletRequest request, String name) {
        request.setAttribute(listLivre, LivreM.getByName(name));
        ArrayList<Category> arr = CategoryM.getAll();
        System.out.println(arr);
        request.setAttribute(listCategory, arr);
    }

    public static void afficherByIdLivre(HttpServletRequest request, int idLivre) {
        request.setAttribute(livreById, LivreM.getByIdLivre(idLivre));
        ArrayList<Category> arr = CategoryM.getAll();
        System.out.println(arr);
        request.setAttribute(listCategory, arr);
    }
}
