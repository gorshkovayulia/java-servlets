package servlets.session;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/session")
public class Session extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession(); // get session object
        String name = (String) session.getAttribute("name"); // get object name

        try (PrintWriter out = response.getWriter()) {
            if (name == null) {
                session.setAttribute("name", "Tom Soyer"); // set object with name key
                out.println("Session data are set");
            } else {
                out.println("Name: " + name);
                session.removeAttribute("name"); // remove object with name key
            }
        }
    }
}
