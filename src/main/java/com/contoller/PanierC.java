package com.contoller;

import com.action.PanierA;
import com.entity.Livre;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PanierC", urlPatterns = {"/panierC"})
public class PanierC extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String idLivreForCart = request.getParameter("idLivreForCart");
        String ajouterQty = request.getParameter("ajouterQty");
        String diminuerQty = request.getParameter("diminuerQty");
        String afficherPanier = request.getParameter("afficherPanier");
        String viderPanier = request.getParameter("viderPanier");
        String urlRetour = "panier.jsp";
        Livre livre = (Livre) request.getAttribute("livreById");

        if (livre != null) {
            PanierA.ajouterAuPanier(request);
            urlRetour = "index.jsp";
        } else if (afficherPanier != null) {
            PanierA.afficherPanier(request);
        } else if (ajouterQty != null) {
            PanierA.ajouterAuPanier(request);
        } else if (diminuerQty != null) {
            PanierA.enleverDuPanier(request);
        } else if (viderPanier != null) {
            PanierA.viderPanier(request);

        }
        request.getRequestDispatcher(urlRetour).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
