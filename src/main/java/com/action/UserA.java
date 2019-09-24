/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.entity.User;
import com.manager.SessionM;
import com.manager.UserM;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rwang
 */
public class UserA {

    private static UserM userm = new UserM(); // init a user manager
    private static SessionM sessionm = new SessionM(); // init a session manager

    /**
     * user signup
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public void signup(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("com.action.UserA.signup()");
        // get params
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");

        // encapsulation of new user
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setPrenom(prenom);
        user.setNom(nom);
        user.getRole().setId(2);

        // call the user manager - signup
        userm.addUser(user);

        // redirect
        response.sendRedirect(request.getContextPath() + "/signin.jsp");
    }

    /**
     * user signin
     *
     * @param request
     * @param response
     */
    public void signin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("com.action.UserA.signin()");
        // get params
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        System.out.println("emial from signin form: " + email);
        System.out.println("password from signin form: " + password);
        // encapsulation
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        // call the UserA - checkLogin()
        User existUser = userm.checkLogin(user);
        System.out.println("==============");
        System.out.println("==============");
        System.out.println("==============");

        System.out.println(existUser.getNom());

        // handle result
        if (existUser.getNom() == null) {
            System.out.println("false: " + existUser.getNom());
            // fail login, send message to the user
            request.setAttribute("msg", "Wrong email or password, please try again");
            request.getRequestDispatcher("/signin.jsp").forward(request, response);
        } else {
            // create session
            HttpSession session = request.getSession();
            session.setAttribute("user", existUser);

            System.out.println("com.action.UserA.signin()");
            // redirect
            response.sendRedirect(request.getContextPath() + "/livreC");

        }

    }

}
