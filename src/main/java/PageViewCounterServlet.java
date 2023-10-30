import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "PageViewCounter", urlPatterns = "/count")
public class PageViewCounterServlet extends HttpServlet {

    private static int count = 0;
    protected void doGet(HttpServletRequest req, HttpServletResponse res) {

        String reset = req.getParameter("reset");
        if(reset != null) {
            try {
                count = 0;
                res.sendRedirect("/count");
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            try {
                res.setContentType("text/html");
                PrintWriter out = res.getWriter();
                out.println("<h1>The page has been viewed " + count + " times!</h1>");
                count++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
