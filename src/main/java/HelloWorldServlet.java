import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//Create a page that displays "Hello World!" when a user visits /hello

@WebServlet(name = "HelloWorldServlet", urlPatterns ="/hello")
public class HelloWorldServlet extends HttpServlet {

//    Make the page say "Hello, <name>!" if name is passed as part of the query string (e.g. /hello?name=codeup), otherwise default to "Hello, World!".

    protected void doGet(HttpServletRequest req, HttpServletResponse res) {

        //when the url looks like this: http://localhost:8080/hello?name=codeup
        //the page will display "Hello, codeup!" otherwise it will display "Hello, World!"

        String name = req.getParameter("name");
        if(name == null) {
            name = "World";
        }
            try {
                res.setContentType("text/html");
                PrintWriter out = res.getWriter();
                out.println("<h1>Hello, " + name + "!</h1>");
            } catch (IOException e) {
                e.printStackTrace();
            }



    }
}
