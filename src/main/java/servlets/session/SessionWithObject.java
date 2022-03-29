package servlets.session;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/person")
public class SessionWithObject extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();
        Person tom = (Person) session.getAttribute("person");

        try (PrintWriter out = response.getWriter()) {
            if (tom == null) {
                tom = new Person("Tom", 34);
                session.setAttribute("person", tom);
                out.println("Session data are set");
            } else {
                out.println("Name: " + tom.getName() + " Age: " + tom.getAge());
                session.removeAttribute("person");
            }
        }
    }
}
