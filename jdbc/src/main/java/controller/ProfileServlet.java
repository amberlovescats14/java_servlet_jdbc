package controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "profile", urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse res
                ) {
        //get
        try {
            Boolean loggedIn = (Boolean)req.getSession().getAttribute("loggedIn");
            if(loggedIn == null || !loggedIn){
                req.getSession().invalidate();
                res.sendRedirect("/login");
                return;
            }
           req.getRequestDispatcher("/WEB-INF/users/profile.jsp").forward(req,res);
            return;
        } catch(IOException | ServletException ex) {
            System.out.printf("ERROR: %s\n", ex);
        }

    }


}
