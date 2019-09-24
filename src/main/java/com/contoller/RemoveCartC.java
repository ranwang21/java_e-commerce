/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contoller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Cart;
import com.bean.CartItem;
import com.entity.Livre;
import com.manager.LivreM;

/**
 *
 * @author rwang
 */
@WebServlet(name = "removeCart", urlPatterns = {"/removeCart"})
public class RemoveCartC extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String pidStr = request.getParameter("pid");

        Integer pid = Integer.parseInt(pidStr);

        // get cart object
        Cart cart = (Cart) session.getAttribute("cart");
        cart.removeCart(pid);
        request.getRequestDispatcher("/cart.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
