package controller;

import dao.UserDAO;
import java.util.Vector;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;
import model.User;
import util.Helper;

/**
 *
 * @author Huy Nguyen
 */
public class CheckoutController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        }
    } 

    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Helper.getCategory(request);
        Helper.getBrand(request);
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null || cart.getItems().isEmpty()) {
            session.setAttribute("notiType", "RED");
            session.setAttribute("notification", "Your cart is empty!");
            response.sendRedirect("home");
        } else {
            if (session.getAttribute("userId") != null) {
                UserDAO udao = new UserDAO();
                int userId = (Integer)session.getAttribute("userId");
                User user = udao.getById(userId);
                request.setAttribute("firstName", user.getFirstName());
                request.setAttribute("lastName", user.getLastName());
                request.setAttribute("street", user.getStreet());
                request.setAttribute("city", user.getCity());
                request.setAttribute("province", user.getProvince());
                request.setAttribute("country", user.getCountry());
                request.setAttribute("email", user.getEmail());
                request.setAttribute("phone", user.getPhone());
                
                Vector<String> creditCardInfo = udao.getPaymentInfo(userId, 1);
                request.setAttribute("cardNumber", creditCardInfo.get(0));
                request.setAttribute("expirationDate", creditCardInfo.get(1));
                request.setAttribute("expirationYear", creditCardInfo.get(2));
                request.setAttribute("cvv", creditCardInfo.get(3));
            }
            request.getRequestDispatcher("/jsp/checkoutPage.jsp").forward(request, response);
        }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
