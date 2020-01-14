package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "test", urlPatterns = "/test")
public class TestServlet extends HttpServlet {

    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse res
    ) {
        try {
            String name = "amber";
            req.setAttribute("name", name);
            req.getRequestDispatcher("/index.jsp").forward(req,res);
        } catch(IOException | ServletException ex) {
            System.out.printf("ERROR: %s\n", ex);
        }

    }
}
