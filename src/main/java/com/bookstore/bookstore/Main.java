package com.bookstore.bookstore;

import com.bookstore.bookstore.controller.UserController;
import com.bookstore.bookstore.model.User;

public class Main {
    public static void main(String[] args) {
        // create the dao object
        UserController userController = new UserController();
        // create and save the product
        User user = new User("tiemouie01", "090500", "admin");
        userController.saveUser(user);
    }

}
