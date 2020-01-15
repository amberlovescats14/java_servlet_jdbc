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

@WebServlet(name = "all", urlPatterns = "/all-users")
public class UsersServlet extends HttpServlet {

    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse res
    ) {
        try {
            ArrayList<User> allUsers = new MySQLUserDao().getAll();

            req.setAttribute("allUsers", allUsers);
            req.getRequestDispatcher("/WEB-INF/users/index.jsp").forward(req,res);
        } catch(IOException | ServletException ex) {
            System.out.printf("ERROR: %s\n", ex);
        }
    }
}
