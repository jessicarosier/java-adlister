import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PizzaOrderServlet", urlPatterns = "/pizza-order")
public class PizzaOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/order.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> toppings = new ArrayList<>();

        HttpSession session = request.getSession();
        session.setAttribute("order", "complete");

        String crust = request.getParameter("crust");
        request.setAttribute("crust", crust);
        System.out.println(crust);

        String sauce = request.getParameter("sauce");
        request.setAttribute("sauce", sauce);

        String size = request.getParameter("size");
        request.setAttribute("size", size);

        String mushrooms = request.getParameter("mushrooms");
        request.setAttribute("mushrooms", mushrooms);
        if(mushrooms != null) {
            toppings.add(mushrooms);
        }

        String pineapple = request.getParameter("pineapple");
        request.setAttribute("pineapple", pineapple);
        if(mushrooms != null) {
            toppings.add(pineapple);
        }

        String pepperoni = request.getParameter("pepperoni");
        request.setAttribute("pepperoni", pepperoni);
        if(pepperoni != null) {
            toppings.add(pepperoni);
        }

        String sausage = request.getParameter("sausage");
        request.setAttribute("sausage", sausage);
        if(sausage != null) {
            toppings.add(sausage);
        }

        request.setAttribute("toppings", toppings);


        String address = request.getParameter("address");
        request.setAttribute("address", address);

        request.getRequestDispatcher("/order.jsp").forward(request, response);
    }

}
