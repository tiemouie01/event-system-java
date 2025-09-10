package com.bookstore.bookstore.servlets;

import com.bookstore.bookstore.controller.BookController;
import com.bookstore.bookstore.model.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admin/book/create")
public class CreateBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("createBook.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        double price =   Double.parseDouble(req.getParameter("price"));
        int stock =   Integer.parseInt(req.getParameter("stock"));

        BookController bookController = new BookController();
        Book book = new Book(title,author,price,stock);
        bookController.saveBook(book);

        resp.sendRedirect("/BookStore/books");
    }
}
