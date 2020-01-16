package controller;

import dao.users.MySQLUserDao;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "edit", urlPatterns = "/edit-profile")
public class EditUserServlet extends HttpServlet {
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse res
                ) {
        //get
        try {
            Boolean loggedIn = (Boolean) req.getSession().getAttribute("loggedIn");
            if(loggedIn != null && loggedIn ){
                req.getRequestDispatcher("/WEB-INF/users/edit.jsp").forward(req,res);
            }
            else {
                req.getSession().invalidate();
                res.sendRedirect("/login");
            }

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
            Long id = Long.valueOf(req.getParameter("id"));
            String username = req.getParameter("username");
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            User user = new User(
                    id,
                    username,
                    email,
                    password
            );
            new MySQLUserDao().updateUserById(user);
            res.sendRedirect("/all-users");

        } catch(IOException ex) {
            System.out.printf("ERROR: %s\n", ex);
        }

    }
}
