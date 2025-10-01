package com.event.servlets;

import com.event.controller.EventController;
import com.event.model.Event;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/admin/events/delete")
public class DeleteEventServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id =  Long.parseLong(req.getParameter("id"));
        EventController eventController = new EventController();
        eventController.deleteEvent(id);
        resp.sendRedirect("/admin");
    }
}
