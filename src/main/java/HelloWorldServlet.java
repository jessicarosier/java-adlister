import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("SessionColor") == null) {
            request.setAttribute("helloPageColor", "yellow");
        } else {
            request.setAttribute("helloPageColor", session.getAttribute("SessionColor"));
        }
        response.getWriter().println("<h1>Hello, World!</h1>");
    }


}
