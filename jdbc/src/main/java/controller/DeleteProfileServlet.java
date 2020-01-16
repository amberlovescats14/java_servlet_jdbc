package controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

@WebServlet(name = "delete", urlPatterns = "/delete")
public class DeleteProfileServlet extends HttpServlet {
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse res
                ) {
        //get
        try {
            res.sendRedirect("/profile");
        } catch(IOException  ex) {
            System.out.printf("ERROR: %s\n", ex);
        }

    }
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse res
                ) {
        //post
        try {
         Boolean loggedIn = (Boolean) req.getSession().getAttribute("loggedIn");
         if(loggedIn != null && loggedIn){
             req.getRequestDispatcher("/WEB-INF/users/confirm.jsp").forward(req, res);
             return;
         }

        } catch(IOException | ServletException ex) {
            System.out.printf("ERROR: %s\n", ex);
        }

    }
}
