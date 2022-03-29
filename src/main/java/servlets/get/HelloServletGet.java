package servlets.get;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

// Get request without parameters
@WebServlet("/hello")
public class HelloServletGet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        ServletOutputStream writer = response.getOutputStream();
        try {
            Thread.sleep(5000);
            response.setStatus(200);
            writer.println("<h2>Hello from HelloServlet</h2>");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
