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

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //stores the plaintext info the user typed into the form
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        //if the plain text password and password confirmation match, then hash the password and store the hash in a variable
        String hashedPassword = new String();
        if (password.equals(passwordConfirmation)) {
           hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));
        } else {
            //if the plaintext password and passwordConfirmation DO NOT match, redirect them to the registration form
            response.sendRedirect("/register");
        }

        // validate input
        boolean inputHasErrors = username.isEmpty()
            || email.isEmpty()
            || password.isEmpty()
            || (! password.equals(passwordConfirmation));

        if (inputHasErrors) {
            response.sendRedirect("/register");
            return;
        }

        // create and save a new user, store the hashedPassword in the DB
        User user = new User(username, email, hashedPassword);
        DaoFactory.getUsersDao().insert(user);
        response.sendRedirect("/login");
    }
}
