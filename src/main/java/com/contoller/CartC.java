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
@WebServlet(name = "addCart", urlPatterns = {"/addCart"})
public class CartC extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        // get params
        String pidStr = request.getParameter("pid");
        String countStr = request.getParameter("count");
        Integer pid = Integer.parseInt(pidStr);
        Integer count = Integer.parseInt(countStr);
        //get the product
        Livre livre = LivreM.getByIdLivre(pid);

        //encapsulation of cart item
        CartItem cartItem = new CartItem();
        cartItem.setLivre(livre);
        cartItem.setCount(count);
        cartItem.setPrice(livre.getPrix());

        // get the cart from user session
        Cart cart = (Cart) session.getAttribute("cart");
        // if user does not have a session cart, add one
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        // put cartItem into the cart and redirect
        cart.addCart(cartItem);
        request.getRequestDispatcher("/cart.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
