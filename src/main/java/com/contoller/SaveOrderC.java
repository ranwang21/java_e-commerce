/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contoller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Cart;
import com.bean.CartItem;
import com.entity.Commande;
import com.entity.CommandeWrapper;
import com.entity.Livre;
import com.entity.User;
import com.manager.CommandeM;
import com.manager.LivreM;
import com.utils.OrderUtil;

/**
 *
 * @author rwang
 */
@WebServlet(name = "saveOrder", urlPatterns = {"/saveOrder"})
public class SaveOrderC extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        /**
         * check if user is login
         */
        User user = (User) session.getAttribute("user");
        if (user == null) {

            request.setAttribute("info", "no login please login！！！");

            //redirect
            request.getRequestDispatcher("/info.jsp").forward(request, response);
            return;

        }
        /**
         * if the cart is null
         */
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            request.setAttribute("info", "cart is enpty！！！");

            //redirect
            request.getRequestDispatcher("/info.jsp").forward(request, response);
            return;
        }
        /**
         * init order object
         */

        //generate ramdom order id
        String orderNo = OrderUtil.getOrderIdByTime();
        Commande order = new Commande();
        order.setIdUser(user.getId());
        order.setTotal(cart.getTotal());
        CommandeM.addCommande(order); // persist order in database

        Integer orderId = order.getId();

        /**
         * order collection
         */
        Set<CommandeWrapper> sets = new HashSet<CommandeWrapper>();
        for (CartItem cartItem : cart.getCartItems()) {
            //transform item into OrderItem
            CommandeWrapper orderItem = new CommandeWrapper();
            orderItem.setIdCommande(orderId);
            orderItem.setIdLivre(cartItem.getLivre().getId());
            orderItem.setQty(cartItem.getCount());
            orderItem.setSubtotal(cartItem.getSubtotal());
            orderItem.setLivre(cartItem.getLivre());
            CommandeM.addCommandeList(orderItem);
            sets.add(orderItem);
        }

        order.setOrderItems(sets);

        /**
         * clear cart
         */
        cart.clearCart();

        request.setAttribute("order", order);
        request.setAttribute("orderNo", orderNo);

        request.getRequestDispatcher("/order.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
