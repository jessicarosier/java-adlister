import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "PageViewCounterServlet", urlPatterns = "/count")
public class PageViewCounterServlet extends HttpServlet {
    protected int count = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String reset = request.getParameter("reset");
        System.out.println(reset);

        if (reset != null) {
            count = 0;
            response.sendRedirect("/count");
        }

        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1>The current page view count is: " + count + "</h1>");
            count++;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
