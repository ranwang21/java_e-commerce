package com.action;

import com.entity.Livre;
import com.entity.LivrePanierWrapper;
import com.manager.PanierM;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class PanierA {

    public static void ajouterAuPanier(HttpServletRequest request) {
        PanierM.add(request, (Livre) request.getAttribute("livreById"));
    }

    public static void enleverDuPanier(HttpServletRequest request) {
        PanierM.removeQty(request, (Livre) request.getAttribute("livreById"));
    }

    public static void afficherPanier(HttpServletRequest request) {
        ArrayList<LivrePanierWrapper> lpw = PanierM.getLivrePanier(request);
        request.setAttribute("listLivrePanier", lpw);
    }
    public static void viderPanier(HttpServletRequest request){
        PanierM.viderPanier(request);
    }
}
