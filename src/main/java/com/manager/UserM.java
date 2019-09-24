/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manager;

import com.entity.User;
import com.service.ConnectionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rwang
 */
public class UserM {

    /**
     * check login
     *
     * @param user
     * @return
     */
    public User checkLogin(User user) {
        ResultSet result;
        User existUser = new User();

        System.out.println("com.manager.UserM.checkLogin()");
        try {
            // write sql
            String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
            // init preparedStatement and preprocess
            PreparedStatement ps = ConnectionDB.getPs(sql);
            // fill sql params
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            // execute
            result = ps.executeQuery();
            // handle result
            if (result.next()) {
                existUser.setId(result.getInt("id"));
                existUser.setEmail(result.getString("email"));
                existUser.setPassword(result.getString("password"));
                existUser.getRole().setId(result.getInt("idRole"));
                existUser.setNom(result.getString("nom"));
                existUser.setPrenom(result.getString("prenom"));
                System.out.println("userExist found");
            }
            System.out.println(existUser);

        } catch (SQLException ex) {
            Logger.getLogger(LivreM.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // release
            ConnectionDB.close();
        }
        return existUser;

    }

    /**
     * sign up
     */
    public void addUser(User user) {
        try {
            // write sql
            String sql = "INSERT INTO user VALUES(null, ?, ?, ?, ?, ?)";
            // init preparedStatement and preprocess
            PreparedStatement ps = ConnectionDB.getPs(sql);
            // fill sql params
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getPrenom());
            ps.setString(4, user.getNom());
            ps.setInt(5, user.getRole().getId());
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
