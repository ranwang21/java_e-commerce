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
@WebServlet(name = "pay", urlPatterns = {"/pay"})
public class PayC extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessionOld = request.getSession();
        User user = (User) sessionOld.getAttribute("user");

        String no = request.getParameter("no");
        String name = request.getParameter("name");
        String orderIdStr = request.getParameter("orderId");

        ArrayList<CommandeWrapper> list = CommandeM.getByIdCommande(Integer.parseInt(orderIdStr));

        Date date = new Date();
        String str = "yyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(str);
        String time = sdf.format(date);
        System.out.println(time);

        // get user's email address
        String to = user.getEmail();

        //fill product name, quantity
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("dear:" + name + " Your order number :" + no + " was successfully placed in " + time);

            for (CommandeWrapper commandeWrapper : list) {
                Livre livre = LivreM.getByIdLivre(commandeWrapper.getIdLivre());
                sb.append(" product name:" + livre.getNom() + " count:" + commandeWrapper.getQty() + " price:" + livre.getPrix() * commandeWrapper.getQty() + " ");
            }

            //MailUtils.send("pay success", sb.toString(), to);
            MailUtils.sendMail();

        } catch (Exception mex) {
            mex.printStackTrace();
        }

        //send mail
        request.setAttribute("info", "pay success！！！");

        //redirect
        request.getRequestDispatcher("/livreC").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
