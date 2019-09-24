/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contoller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Cart;
import com.entity.CommandeWrapper;
import com.entity.Livre;
import com.entity.User;
import com.manager.CommandeM;
import com.manager.LivreM;
import com.utils.MailUtils;

/**
 *
 * @author rwang
 */
@WebServlet("/ReduceCount")
public class ReduceCount extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String idStr = request.getParameter("id");
        Integer id = Integer.parseInt(idStr);
        String countStr = request.getParameter("count");
        Integer count = Integer.parseInt(countStr);
        Cart cart = (Cart) session.getAttribute("cart");

        if (count <= 0) {
            //send error and reset count to 0
            request.setAttribute("info", "The quantity cannot be zero");
            request.setAttribute("pid", id);
            request.setAttribute("count", 0);
            //redirect
            request.getRequestDispatcher("/cart_info.jsp").forward(request, response);
            return;
        }
        // refresh the page with count--
        response.sendRedirect(request.getContextPath() + "/addCart?pid=" + id + "&count=-1");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
