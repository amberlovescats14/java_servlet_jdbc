package controller.ads;

import dao.DaoFactory;
import models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "create", urlPatterns = "/create-ad")
public class CreateAdsServlet extends HttpServlet {
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse res
    ) {
        try {
            Boolean loggedIn = (Boolean) req.getSession().getAttribute("loggedIn");
            if(loggedIn != null && loggedIn){
                req.getRequestDispatcher("/WEB-INF/ads/create.jsp").forward(req,res);
            }
            else res.sendRedirect("/login");
        } catch(IOException | ServletException ex) {
            System.out.printf("ERROR: %s\n", ex);
        }
    }

    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse res
    ) {
        try {
            String userId = (String)req.getAttribute("userId");
            String title = (String) req.getAttribute("title");
            String description = (String) req.getAttribute("description");
            String category = (String) req.getAttribute("category");

            Boolean confirm = !userId.isEmpty() ||
                    !title.isEmpty() ||
                    !description.isEmpty() ||
                    !category.isEmpty();

            if(confirm){
                Ad ad = new Ad(
                        Long.valueOf(userId),
                        title,
                        description,
                        category
                );
                DaoFactory.getAdsDao().createAd(ad);
                res.sendRedirect("/ads");
            }
            else res.sendRedirect("/create-ad?alert=true");
        } catch(IOException ex) {
            System.out.printf("ERROR: %s\n", ex);
        }

    }
}
