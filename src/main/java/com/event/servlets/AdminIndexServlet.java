package com.event.servlets;

import com.event.controller.EventController;
import com.event.model.Event;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/admin")
public class AdminIndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        String role = (String) session.getAttribute("role");
        if (username == null) {
            resp.sendRedirect("/login");
            return;
        }

        if (role.equals("USER")) {
            resp.sendRedirect("/home");
            return;
        }

        EventController eventController = new EventController();
        List<Event> events = eventController.getEvents();
        req.setAttribute("events", events);

        RequestDispatcher rd = req.getRequestDispatcher("admin.jsp");
        rd.forward(req, resp);
    }
}
