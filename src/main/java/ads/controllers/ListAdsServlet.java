package ads.controllers;

import ads.model.Ad;
import ads.dao.Ads;
import ads.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet (urlPatterns = "/ads")
public class ListAdsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Ads listAds = DaoFactory.getAdsDao();

        List<Ad> ads = listAds.all();

        request.setAttribute("ads", ads);

        request.getRequestDispatcher("/ads/index.jsp").forward(request, response);
    }
}
