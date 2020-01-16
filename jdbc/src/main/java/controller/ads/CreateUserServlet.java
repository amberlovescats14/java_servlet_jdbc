//package controller.ads;
//
//import com.sun.org.apache.xpath.internal.operations.Bool;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet(name = "create", urlPatterns = "/create-user")
//public class CreateUserServlet extends HttpServlet {
//    protected void doGet(
//            HttpServletRequest req,
//            HttpServletResponse res
//                ) {
//        //get
//        try {
//            Boolean loggedIn = (Boolean) req.getSession().getAttribute("loggedIn");
//            if(loggedIn != null && loggedIn){
//                req.getRequestDispatcher("/WEB-INF/users/create.jsp").forward(req,res);
//            }
//
//        } catch(IOException | ServletException ex) {
//            System.out.printf("ERROR: %s\n", ex);
//        }
//
//    }
//    protected void doPost(
//            HttpServletRequest req,
//            HttpServletResponse res
//                ) {
//        //post
//        try {
//
//        } catch(IOException | ServletException ex) {
//            System.out.printf("ERROR: %s\n", ex);
//        }
//
//    }
//}
