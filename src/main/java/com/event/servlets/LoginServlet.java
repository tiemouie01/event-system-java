package com.event.servlets;

import com.event.controller.UserController;
import com.event.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get values from form
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Check if user credentials match the database data
        UserController  userController = new UserController();
        User user = userController.getUserByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            resp.sendRedirect("login.jsp");
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("userId", user.getId());
            session.setAttribute("username", user.getUsername());
            if (user.getRole().equals("ADMIN")) {
                session.setAttribute("role", "ADMIN");
                resp.sendRedirect("/admin");
            } else {
                session.setAttribute("role", "USER");
                resp.sendRedirect("home.jsp");
            }
        }
    }
}
