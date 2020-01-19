package controller.ads;

import dao.DaoFactory;
import models.Ad;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "all", urlPatterns = "/ads")
public class AllAdsServlet extends HttpServlet {

    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse res
    ) {
        try {
            Boolean loggedIn = (Boolean) req.getSession().getAttribute("loggedIn");
            if(loggedIn != null && loggedIn){
                ArrayList<Ad> allAds = DaoFactory.getAdsDao().getAll();
                req.setAttribute("allAds", allAds);
                req.getRequestDispatcher("/WEB-INF/ads/index.jsp");
                return;
            }
            res.sendRedirect("/login");
        } catch(IOException ex) {
            System.out.printf("ERROR: %s\n", ex);
        }

    }
}
