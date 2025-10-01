package com.event.servlets;

import com.event.controller.BookingController;
import com.event.controller.EventController;
import com.event.controller.UserController;
import com.event.model.Booking;
import com.event.model.Event;
import com.event.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/events/book")
public class BookEventServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id =  Integer.parseInt(req.getParameter("eventId"));
        EventController eventController = new EventController();
        Event event = eventController.getEventById(id);

        req.setAttribute("event", event);
        RequestDispatcher rd = req.getRequestDispatcher("/book-event.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Long userId =  (Long) session.getAttribute("userId");
        Long eventId =  Long.parseLong(req.getParameter("eventId"));
        LocalDate bookingDate = LocalDate.now();
        int numberOfTickets =   Integer.parseInt(req.getParameter("number_of_tickets"));

        UserController userController = new UserController();
        User user = userController.getUserById(userId.intValue());
        EventController eventController = new EventController();
        Event event = eventController.getEventById(eventId.intValue());

        BookingController bookingController = new BookingController();
        Booking booking = new Booking(bookingDate, numberOfTickets, user, event);
        bookingController.saveBooking(booking);

        event.setAvailableSeats(event.getAvailableSeats() - numberOfTickets);
        eventController.updateEvent(event);

        resp.sendRedirect("/home");
    }
}
