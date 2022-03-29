package servlets.get;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// Get request with parameters
@WebServlet("/hello3")
public class HelloServletGet3 extends HttpServlet {
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.setContentType("text/html");

        String[] nums = httpServletRequest.getParameterValues("nums");

        try (PrintWriter writer = httpServletResponse.getWriter()) {
            writer.print("<h2>Numbers: ");
            for (String n : nums) {
                writer.print(n + " ");
            }
            writer.println("</h2>");
        }
    }
}
