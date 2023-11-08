package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //stores the plaintext username and password the user typed into the form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //see if the user exists in the database and return a User obj
        User user = DaoFactory.getUsersDao().findByUsername(username);

        //if the user returned is Null, then the user did not exist in the DB
        //maybe they typed in their login info incorrect? send them back to the login screen
        if (user == null) {
            response.sendRedirect("/login");
            return;
        }

        //gets the hash from the DB that belongs to the user and checks to see if the hash belongs to the password the user typed in
        //returns True or False
        boolean passwordsMatch = BCrypt.checkpw(password, user.getPassword());


        //if it's true that the stored hash belongs to the password the user typed in, then allow them to login and take them to their profile
        if (passwordsMatch) {
            //set a session attribute to a user object of the user who just logged in
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/login");
        }
    }
}
