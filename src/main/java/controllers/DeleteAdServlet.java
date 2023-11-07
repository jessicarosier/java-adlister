package controllers;

import dao.DaoFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet (urlPatterns = "/delete")
public class DeleteAdServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String adId = request.getParameter("adid");
        System.out.println(adId);

        try {
            DaoFactory.getAdsDao().delete(adId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("/ads");

    }
}
