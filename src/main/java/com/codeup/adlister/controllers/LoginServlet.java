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
        //stores the user input from the login form
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        // TODO: find a record in your database that matches the submitted password
        // TODO: make sure we find a user with that username
        // TODO: check the submitted password against what you have in your database
        //DaoFactory.getUsersDao() is an instance of a MySQLUsersDao,
        // .findByUsername() is a method that returns a User Object
        // .getUsername() is a method that can be called on a User Object

        User userFromDb = DaoFactory.getUsersDao().findByUsername(username);

        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(hashedPassword);

        boolean passwordsMatch = BCrypt.checkpw(hashedPassword, userFromDb.getPassword());
        System.out.println(passwordsMatch);
        System.out.println(userFromDb.getPassword());


        if (userFromDb == null) {
            response.sendRedirect("/login");
        } else if (userFromDb.getUsername().equalsIgnoreCase(username) && passwordsMatch){
            // TODO: store the logged in user object in the session, instead of just the username
            request.getSession().setAttribute("user", username);
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/login");
        }
    }
}
