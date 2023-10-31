import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello-world")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");

        if(name == null) {
            name = "World";
        }

        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1>Hello, " + name + "!</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
