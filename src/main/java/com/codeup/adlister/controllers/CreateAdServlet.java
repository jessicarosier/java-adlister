package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //if its TRUE that the user is logged in, allow them to continue to the create post page
        if(request.getSession().getAttribute("user") != null) {
            request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
                    .forward(request, response);
        } else {
            //else if they are NOT logged in, redirect them back to the view ads page
            response.sendRedirect("/ads");
        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //get the USER info of the user who is currently logged in to THIS session
        User user = (User) request.getSession().getAttribute("user");

        //creates the new Ad in the DB and sets the User ID to the user who posted it!
        Ad ad = new Ad(
                user.getId(),
            request.getParameter("title"),
            request.getParameter("description")
        );
        DaoFactory.getAdsDao().insert(ad);
        response.sendRedirect("/ads");
    }
}
