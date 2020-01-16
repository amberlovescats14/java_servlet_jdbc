package controller;

import dao.users.MySQLUserDao;
import dao.users.Users;
import models.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "register", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse res
    ) {
        try {
            req.getRequestDispatcher("/WEB-INF/users/register.jsp").forward(req,res);

        } catch(IOException | ServletException ex) {
            System.out.printf("ERROR: %s\n", ex);
        }
    }

    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse res
    ) {
        try {
            String username = req.getParameter("username");
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            String hash = BCrypt.hashpw(password, BCrypt.gensalt());
            User user = new User(username,email, hash);

            new MySQLUserDao().createUser(user);

            res.sendRedirect("/all-users");
        } catch(IOException ex) {
            System.out.printf("ERROR: %s\n", ex);
        }
    }
}
