package controller.ads;

import dao.users.MySQLUserDao;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "confirm", urlPatterns = "/confirm-delete")
public class ConfirmDeleteServlet extends HttpServlet {

    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse res
                ) {
        //get
        try {
            req.getRequestDispatcher("/WEB-INF/users/confirm.jsp").forward(req,res);

        } catch(IOException | ServletException ex) {
            System.out.printf("ERROR: %s\n", ex);
        }

    }
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse res
                ) {
        //post
        try {
            User user = (User)req.getSession().getAttribute("user");
            long id = user.getId();
            new MySQLUserDao().deleteById(id);
            req.getSession().invalidate();
            res.sendRedirect("/register");
        } catch(IOException ex) {
            System.out.printf("ERROR: %s\n", ex);
        }
    }
}
