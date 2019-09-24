/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contoller;

import com.action.UserA;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rwang
 */
@WebServlet(name = "UserC", urlPatterns = {"/UserC"})
public class UserC extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // init user action
        UserA userAction = new UserA();

        // get method name
        String methodName = request.getParameter("method");

        // call action(s)
        if ("signup".equals(methodName)) {
            // call action UserA - signup()
            userAction.signup(request, response);
        } else if ("signin".equals(methodName)) {
            // call action UserA - signin()
            System.out.println("get the method signin, ready to call signin action");
            userAction.signin(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
