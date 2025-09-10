package com.bookstore.bookstore.servlets;

import com.bookstore.bookstore.controller.BookController;
import com.bookstore.bookstore.model.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class ListBooksServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookController bookController = new BookController();
        List<Book> books = bookController.getBooks();

        req.setAttribute("books", books);
        RequestDispatcher dispatcher =  req.getRequestDispatcher("/WEB-INF/listBooks.jsp");
        dispatcher.forward(req,resp);
    }
}
