package com.event.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/home")
public class UserHomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String username = (String) session.getAttribute("username");
        String role = (String) session.getAttribute("role");
        if (username == null) {
            resp.sendRedirect("login.jsp");
        }

        if (role.equals("ADMIN")) {
            resp.sendRedirect("/admin");
            return;
        }
        RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
        rd.forward(req, resp);
    }
}
