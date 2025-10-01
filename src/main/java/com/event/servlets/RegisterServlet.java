package com.event.servlets;

import com.event.controller.UserController;
import com.event.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/signup")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role =  req.getParameter("role");

        UserController userController = new UserController();
        User user = new User(username, password, role);
        userController.saveUser(user);
        req.getSession().setAttribute("userId", user.getId());
        req.getSession().setAttribute("username", username);
        req.getSession().setAttribute("role", role);
        if (user.getRole().equals("ADMIN")) {
            resp.sendRedirect("admin.jsp");
        } else {
            resp.sendRedirect("home.jsp");
        }
    }
}
