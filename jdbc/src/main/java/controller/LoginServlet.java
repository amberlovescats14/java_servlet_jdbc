package controller;

import dao.users.MySQLUserDao;
import models.User;

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
            String username = req.getParameter("username").toLowerCase();
            String password = req.getParameter("password").toLowerCase();


            ArrayList<User> allUsers = new MySQLUserDao().getAll();
            for (User user : allUsers) {
                if(user.getUsername().equals(username))
                    if(user.getPassword().equals(password)) {
                        req.getSession().setAttribute("user", user);
                        req.getSession().setAttribute("loggedIn", true);
                        req.getRequestDispatcher("WEB-INF/users/profile.jsp").forward(req,res);
                        System.out.println("yesONE");
                        return;
                    }
                res.sendRedirect("/login?alert=true");
                return;
            }
        } catch(IOException | ServletException ex) {
            System.out.printf("ERROR: %s\n", ex);
        }
    }

}
