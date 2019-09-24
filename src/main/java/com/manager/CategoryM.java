/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manager;

import com.entity.Category;
import com.service.ConnectionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rwang
 */
public class CategoryM {

    /**
     * find all categoties
     */
    public static ArrayList<Category> getAll() {

        // init
        ArrayList<Category> list = null;
        ResultSet result;
        PreparedStatement ps = null;

        try {
            // write sql
            String sql = "SELECT * FROM category";
            // init preparedStatement and preprocess
            ps = ConnectionDB.getPs(sql);
            // execute
            result = ps.executeQuery();
            // handle result
            if (result != null) {
                list = new ArrayList<>();
                while (result.next()) {
                    list.add(new Category(result.getInt("id"),
                            result.getString("description")
                    ));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivreM.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // release
            ConnectionDB.close();
        }

        return list;
    }

    /**
     * optional: add a category
     */
    public static void addCategory(Category category) {
        try {
            // write sql
            String sql = "INSERT INTO category VALUES(null, description = ?)";
            // init preparedStatement and preprocess
            PreparedStatement ps = ConnectionDB.getPs(sql);
            // fill sql params
            ps.setString(1, category.getDescription());
            // execute
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LivreM.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // release
            ConnectionDB.close();
        }
    }

    /**
     * optional: update a category
     */
    public static void updateCategory(Category category) {
        try {
            // write sql
            String sql = "UPDATE FROM category SET description = ? WHERE id = ?";
            // init preparedStatement and preprocess
            PreparedStatement ps = ConnectionDB.getPs(sql);
            // fill sql params
            ps.setInt(1, category.getId());
            ps.setString(2, category.getDescription());
            // execute
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LivreM.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // release
            ConnectionDB.close();
        }
    }

    /**
     * optional: remove a category
     */
    public static void removeCategory(int idCategory) {
        try {
            // write sql
            String sql = "DELETE FROM category WHERE id = ?";
            // init preparedStatement and preprocess
            PreparedStatement ps = ConnectionDB.getPs(sql);
            // fill sql params
            ps.setInt(1, idCategory);
            // execute
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LivreM.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // release
            ConnectionDB.close();
        }
    }
}
