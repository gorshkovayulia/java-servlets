package servlets.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebFilter
public class FilterDemo extends HttpFilter {

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter");

        if(request.getHeader("SESSIONID") == null) {
            response.sendRedirect("http://");
            return;
        }
        filterChain.doFilter(request, response);

        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write("<p>in the filter</p>".getBytes(StandardCharsets.UTF_8));
        response.addHeader("Version", "0.0.1");
        outputStream.flush();
    }
}
