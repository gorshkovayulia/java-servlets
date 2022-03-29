package servlets.redirect;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect")
public class Redirect extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("id");

        if (id == null) {
            response.sendRedirect(request.getContextPath() + "/notfound");
        } else {
            response.setContentType("text/html");
            try (PrintWriter writer = response.getWriter()) {
                writer.println("<h2>Hello Id " + id + "</h2>");
            }
        }
    }
}
