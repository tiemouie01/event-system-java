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

@WebServlet("/admin/events/edit")
public class EditBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id =  Integer.parseInt(req.getParameter("id"));
        EventController eventController = new EventController();
        Event event = eventController.getEventById(id);

        req.setAttribute("event", event);
        RequestDispatcher rd = req.getRequestDispatcher("/edit-event.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id =  Long.parseLong(req.getParameter("id"));
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        LocalDate date = LocalDate.parse(req.getParameter("date"));
        String location = req.getParameter("location");
        int availableSeats =   Integer.parseInt(req.getParameter("available_seats"));

        EventController eventController = new EventController();
        Event event = new Event(id, title, description, date, location, availableSeats);
        eventController.updateEvent(event);

        resp.sendRedirect("/admin");
    }
}
