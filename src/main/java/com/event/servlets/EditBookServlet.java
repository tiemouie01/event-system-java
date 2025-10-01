package com.event.servlets;

import com.event.controller.BookingController;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admin/book/*/edit")
public class EditBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        Long id = Long.valueOf(pathInfo.substring(1));
        BookingController bookController = new BookingController();
        Book book = bookController.geBookById(id.intValue());

        req.setAttribute("book", book);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("editBook.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        double price =   Double.parseDouble(req.getParameter("price"));
        int stock =   Integer.parseInt(req.getParameter("stock"));

        BookingController bookController = new BookingController();
        Book book = new Book(title,author,price,stock);
        bookController.updateBooks(book);

        resp.sendRedirect("/BookStore/books");
    }
}
