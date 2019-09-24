package com.manager;

import com.entity.Livre;
import com.entity.LivrePanierWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public class PanierM {

    public static void add(HttpServletRequest request, Livre livreToAdd) {

        HashMap<Integer, LivrePanierWrapper> panier = (HashMap) request.getAttribute("panier");

        if (panier == null) {
            PanierM.createPanier(request);
        }

        LivrePanierWrapper lpw = null;
        int idLivre = livreToAdd.getId();

        if (panier.containsKey(idLivre)) {
            lpw = panier.get(idLivre);
            lpw.setLivre(livreToAdd);
            int qty = lpw.getQty();
            qty++;
            lpw.setQty(qty);
            panier.put(livreToAdd.getId(), lpw);
        } else {
            lpw = new LivrePanierWrapper(livreToAdd, 1);
            panier.put(idLivre, lpw);
        }
    }

    public static void removeQty(HttpServletRequest request, Livre livretoRemove) {
        HashMap<Integer, LivrePanierWrapper> panier = (HashMap) request.getAttribute("panier");
        if (panier != null) {
            LivrePanierWrapper lpw = null;
            int idLivre = livretoRemove.getId();
            if (panier.containsKey(idLivre)) {
                lpw = panier.get(idLivre);
                int qty = lpw.getQty();
                qty--;
                if (qty <= 0) {
                    panier.remove(idLivre);
                } else {
                    lpw.setQty(qty);
                    panier.put(idLivre, lpw);
                }
            }
        }
    }

    public static void delete(HttpServletRequest request, int idLivre) {
        HashMap<Integer, LivrePanierWrapper> panier = (HashMap) request.getAttribute("panier");
        if (panier != null) {
            if (panier.containsKey(idLivre)) {
                panier.remove(idLivre);
            }
        }
    }

    public static ArrayList<LivrePanierWrapper> getLivrePanier(HttpServletRequest request) {
        HashMap<Integer, LivrePanierWrapper> panier = (HashMap) request.getAttribute("panier");
        ArrayList<LivrePanierWrapper> retour = new ArrayList<>();
        if (panier != null) {
            for (Map.Entry<Integer, LivrePanierWrapper> entry : panier.entrySet()) {
                retour.add(entry.getValue());
            }
        }
        return retour;
    }

    public static void createPanier(HttpServletRequest request) {
        HashMap<Integer, LivrePanierWrapper> panier = new HashMap<>();
        SessionM.add(request, "panier", panier);
    }

    public static void viderPanier(HttpServletRequest request) {
        HashMap<Integer, LivrePanierWrapper> panier = (HashMap) request.getAttribute("panier");
        if (panier != null) {
            panier.clear();
        }
    }
}
