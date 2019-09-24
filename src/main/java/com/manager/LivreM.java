/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manager;

import com.entity.Livre;
import com.service.ConnectionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LivreM {

    //GET
    private static final String queryGetAll = "SELECT * FROM livre";
    private static final String queryGetByIdCategory = "SELECT * FROM livre WHERE idCategory = ?";
    private static final String queryGetByNbPages = "SELECT * FROM livre WHERE page BETWEEN ? AND ?";
    private static final String queryGetByName = "SELECT * FROM livre WHERE name LIKE ?";
    private static final String queryGetByIdLivre = "SELECT * FROM livre WHERE id = ?";

    //INSERT,UPDATE,DELETE
    private static final String queryAddLivre = "INSERT INTO livre VALUES (?,?,?,?,?)";
    private static final String queryUpdateLivre = "UPDATE livre SET nom = ?, page = ?, prix = ?, imageUrl = ?, idCategory = ? WHERE id = ?";
    private static final String queryDeleteLivre = "DELETE FROM livre WHERE id = ?";

    /**
     * find all books
     */
    public static ArrayList<Livre> getAll() {
        ArrayList<Livre> livre = null;

        PreparedStatement ps = ConnectionDB.getPs(queryGetAll);
        ResultSet result;
        try {
            result = ps.executeQuery();
            if (result.isBeforeFirst()) {
                livre = new ArrayList<>();
                while (result.next()) {
                    livre.add(new Livre(
                            result.getInt("id"),
                            result.getString("nom"),
                            result.getInt("page"),
                            result.getDouble("prix"),
                            result.getString("imageUrl"),
                            result.getInt("idCategory"),
                            result.getString("description")
                    ));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivreM.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.close();
        }

        return livre;
    }

    /**
     * get books by category
     */
    public static ArrayList<Livre> getByIdCategory(int idCategory) {
        ArrayList<Livre> livre = null;

        PreparedStatement ps = ConnectionDB.getPs(queryGetByIdCategory);
        ResultSet result;
        try {
            ps.setInt(1, idCategory);
            result = ps.executeQuery();
            if (result.isBeforeFirst()) {
                livre = new ArrayList<>();
                while (result.next()) {
                    livre.add(new Livre(
                            result.getInt("id"),
                            result.getString("nom"),
                            result.getInt("page"),
                            result.getDouble("prix"),
                            result.getString("imageUrl"),
                            result.getInt("idCategory"),
                            result.getString("description")
                    ));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivreM.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.close();
        }

        return livre;
    }

    /**
     * optional: search by book's name
     */
    public static ArrayList<Livre> getByNbPages(int minPage, int maxPage) {
        ArrayList<Livre> livre = null;

        PreparedStatement ps = ConnectionDB.getPs(queryGetByNbPages);
        ResultSet result;
        try {
            ps.setInt(1, minPage);
            ps.setInt(2, maxPage);
            result = ps.executeQuery();
            if (result.isBeforeFirst()) {
                livre = new ArrayList<>();
                while (result.next()) {
                    livre.add(new Livre(result.getInt("id"),
                            result.getString("nom"),
                            result.getInt("page"),
                            result.getDouble("prix"),
                            result.getString("imageUrl"),
                            result.getInt("idCategory"),
                            result.getString("description")
                    ));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivreM.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.close();
        }

        return livre;
    }

    /**
     * Optional: search by book's name
     */
    public static Livre getByName(String name) {
        Livre livre = null;

        PreparedStatement ps = ConnectionDB.getPs(queryGetByName);
        ResultSet result;
        try {
            ps.setString(1, name);
            result = ps.executeQuery();
            if (result.isBeforeFirst()) {
                livre = new Livre();
                while (result.next()) {
                    livre.setId(result.getInt("id"));
                    livre.setNom(result.getString("nom"));
                    livre.setPage(result.getInt("page"));
                    livre.setPrix(result.getDouble("prix"));
                    livre.setImageUrl(result.getString("imageUrl"));
                    livre.setIdCategory(result.getInt("idCategory"));
                    livre.setDescription(result.getString("description"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivreM.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.close();
        }

        return livre;
    }

    /**
     * Find one book by its ID
     */
    public static Livre getByIdLivre(int idLivre) {
        Livre livre = null;

        PreparedStatement ps = ConnectionDB.getPs(queryGetByIdLivre);
        ResultSet result;
        try {
            ps.setInt(1, idLivre);
            result = ps.executeQuery();
            if (result.isBeforeFirst()) {
                livre = new Livre();
                while (result.next()) {
                    livre.setId(result.getInt("id"));
                    livre.setNom(result.getString("nom"));
                    livre.setPage(result.getInt("page"));
                    livre.setPrix(result.getDouble("prix"));
                    livre.setImageUrl(result.getString("imageUrl"));
                    livre.setIdCategory(result.getInt("idCategory"));
                    livre.setDescription(result.getString("description"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivreM.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.close();
        }

        return livre;
    }

    /**
     * optional: add a book
     */
    public static void addLivre(Livre livre) {
        PreparedStatement ps = ConnectionDB.getPs(queryAddLivre);
        try {
            ps.setString(1, livre.getNom());
            ps.setInt(2, livre.getPage());
            ps.setDouble(3, livre.getPrix());
            ps.setString(4, livre.getImageUrl());
            ps.setInt(5, livre.getIdCategory());
            ps.setString(6, livre.getDescription());

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(LivreM.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.close();
        }
    }

    /**
     * optional: update a book
     */
    public static void updateLivre(Livre livre) {
        PreparedStatement ps = ConnectionDB.getPs(queryUpdateLivre);
        try {
            ps.setString(1, livre.getNom());
            ps.setInt(2, livre.getPage());
            ps.setDouble(3, livre.getPrix());
            ps.setString(4, livre.getImageUrl());
            ps.setInt(5, livre.getIdCategory());
            ps.setInt(6, livre.getId());

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(LivreM.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.close();
        }
    }

    /**
     * optional: delete a book
     */
    public static void deleteLivre(int idLivre) {
        PreparedStatement ps = ConnectionDB.getPs(queryDeleteLivre);
        try {
            ps.setInt(1, idLivre);

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(LivreM.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.close();
        }
    }
}
