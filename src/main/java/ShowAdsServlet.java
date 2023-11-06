
import dao.DaoFactoryD;
import models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="ShowAdsServlet", urlPatterns = "/ads")
public class ShowAdsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ListAdsDao listAdsDao = (ListAdsDao) DaoFactory.getAdsDao();

        List<Ad> adsList = listAdsDao.all();

        request.setAttribute("viewAds", adsList);

        request.getRequestDispatcher("/ads/index.jsp").forward(request, response);
    }

}
