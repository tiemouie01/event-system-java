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

@WebServlet("/admin/events/create")
public class CreateEventServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/create-event.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        LocalDate date = LocalDate.parse(req.getParameter("date"));
        String location = req.getParameter("location");
        int availableSeats =   Integer.parseInt(req.getParameter("available_seats"));

        EventController eventController = new EventController();
        Event event = new Event(title, description, date, location, availableSeats);
        eventController.saveEvent(event);

        resp.sendRedirect("/admin");
    }
}
