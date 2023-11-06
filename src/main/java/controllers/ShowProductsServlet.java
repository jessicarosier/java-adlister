package controllers;

import dao.DaoFactoryD;
import dao.ProductsDao;
import models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="ShowProductsServlet", urlPatterns = "/products")
public class ShowProductsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductsDao productsDao = DaoFactoryD.getProductsDao();

        List<Product> products = productsDao.all();

        request.setAttribute("viewProducts", products);

        request.getRequestDispatcher("/products/index.jsp").forward(request, response);
    }
}
