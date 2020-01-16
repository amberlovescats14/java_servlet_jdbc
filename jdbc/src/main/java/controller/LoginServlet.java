package controller;

import dao.users.MySQLUserDao;
import models.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse res
    ) {
        try {
            Boolean loggedIn = (Boolean)req.getSession().getAttribute("loggedIn");
            System.out.println(loggedIn);
            if(loggedIn != null && loggedIn) {
                req.getRequestDispatcher("/WEB-INF/users/profile.js").forward(req,res);
                return;
            }
            req.getRequestDispatcher("WEB-INF/users/login.jsp").forward(req,res);
            return;
        } catch(IOException| ServletException ex) {
            System.out.printf("ERROR: %s\n", ex);
        }
    }
    
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse res
    ) {
        try {
            boolean found = false;
            String username = req.getParameter("username").toLowerCase();
            String password = req.getParameter("password").toLowerCase();


            ArrayList<User> allUsers = new MySQLUserDao().getAll();
            System.out.println(allUsers.size());
            for (User user : allUsers) {
                System.out.println("1: " +user.getUsername());
                System.out.println(user.getPassword());

                if(user.getUsername().equals(username))
                    if(BCrypt.checkpw(password, user.getPassword())) {
                        req.getSession().setAttribute("user", user);
                        req.getSession().setAttribute("loggedIn", true);
                        found = true;

                    }
            }
            if(found) req.getRequestDispatcher("WEB-INF/users/profile.jsp").forward(req,res);
            else res.sendRedirect("/login?alert=true");


        } catch(IOException | ServletException ex) {
            System.out.printf("ERROR: %s\n", ex);
        }
    }

}
