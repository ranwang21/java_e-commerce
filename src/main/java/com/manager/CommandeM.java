/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.entity.Commande;
import com.entity.CommandeWrapper;
import com.service.ConnectionDB;

/**
 *
 * @author fgaudrea
 */
public class CommandeM {

    private static final String queryAddCommande = "INSERT INTO commande(idUser,date) VALUES (?,?)";
    private static final String queryAddCommandeList = "INSERT INTO commandelist(idCommande,idLivre,qty) VALUES (?,?,?)";
    private static final String queryGetCommande = "SELECT * FROM commande WHERE idUser = ?";
    private static final String queryGetCommandeList = "SELECT * FROM commandelist WHERE idCommande = ?";

    public static void addCommande(Commande commande) {
        PreparedStatement ps = ConnectionDB.getPsId(queryAddCommande);

        try {
            ps.setInt(1, commande.getIdUser());
            ps.setString(2, new Date().toString());

            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            while (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                System.out.println("increment id：" + id);
                commande.setId(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivreM.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.close();
        }
    }

    public static void addCommandeList(CommandeWrapper commandeWrapper) {
        PreparedStatement ps = ConnectionDB.getPs(queryAddCommandeList);

        try {
            ps.setInt(1, commandeWrapper.getIdCommande());
            ps.setInt(2, commandeWrapper.getIdLivre());
            ps.setInt(3, commandeWrapper.getQty());

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(LivreM.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.close();
        }
    }

    public static ArrayList<CommandeWrapper> getByIdCommande(int idCommande) {
        ArrayList<CommandeWrapper> commande = null;

        PreparedStatement ps = ConnectionDB.getPs(queryGetCommandeList);
        ResultSet result;
        try {
            ps.setInt(1, idCommande);
            result = ps.executeQuery();
            if (result.isBeforeFirst()) {
                commande = new ArrayList<>();
                while (result.next()) {
                    commande.add(new CommandeWrapper(result.getInt("id"),
                            result.getInt("idLivre"),
                            result.getInt("qty")
                    ));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivreM.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.close();
        }

        return commande;
    }

}
