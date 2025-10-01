package com.event.servlets;

import com.event.controller.BookingController;
import com.event.controller.EventController;
import com.event.model.Booking;
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

@WebServlet("/admin/events/bookings")
public class AdminBookingsServlet extends HttpServlet {
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

        Long id =  Long.parseLong(req.getParameter("id"));
        EventController eventController = new EventController();
        Event event = eventController.getEventById(id.intValue());

        BookingController  bookingController = new BookingController();
        List<Booking> bookings = bookingController.getBookingsByEventId(id.intValue());

        req.setAttribute("event", event);
        req.setAttribute("bookings", bookings);
        RequestDispatcher rd = req.getRequestDispatcher("/bookings.jsp");
        rd.forward(req, resp);

    }
}
