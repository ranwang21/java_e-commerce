package com.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionM {

    public static void add(HttpServletRequest request, String key, Object value) {
        HttpSession session = request.getSession();
        session.setAttribute(key, value);
    }

    public static Object get(HttpServletRequest request, String key) {
        HttpSession session = request.getSession();
        return session.getAttribute(key);
    }

    public static void logOut(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
    }
}
