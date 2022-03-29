package servlets.get;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// Get request with parameters
@WebServlet("/hello2")
public class HelloServletGet2 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String name = request.getParameter("name");
        String age = request.getParameter("age");

        try (PrintWriter writer = response.getWriter()) {
            writer.println("<h2>Name: " + name + "; Age: " + age + "</h2>");
        }
    }
}
