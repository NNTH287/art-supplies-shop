package controller;

import dao.OrderDAO;
import dao.OrderDetailDAO;
import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.Helper;
import model.Order;
import java.time.format.DateTimeFormatter;
import model.Cart;
import model.CartItem;
import model.OrderDetail;
import model.User;

/**
 *
 * @author Huy Nguyen
 */
public class OrderController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OrderController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Helper.getBrand(request);
        Helper.getCategory(request);
        HttpSession session = request.getSession();
        if (session.getAttribute("userId") != null) {
            OrderDAO odao = new OrderDAO();
            session.setAttribute("orders", odao.getByUserId((Integer) session.getAttribute("userId")));
        }
        request.getRequestDispatcher("/jsp/orderPage.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId = -1;
        if (session.getAttribute("userId") == null) {
            System.out.println(request.getParameter("newAccount"));
            if (request.getParameter("newAccount") == null) {
                userId = Helper.createAccount(request, "Guest", true); //return id = true
                session.setAttribute("notification", "Order successfully! Please check your email for order details!");
                response.sendRedirect("home");
            } else if (request.getParameter("newAccount").equals("on")) {
                userId = Helper.createAccount(request, "Customer", true); //return id = true
                session.setAttribute("notification", "Order successfully! Please loginto see order details!");
                response.sendRedirect("login");
            }
        } else {
            userId = (Integer) session.getAttribute("userId");
            response.sendRedirect("order");
        }
        insertOrderInfo(session, request, userId);
        clearCart(session);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

    protected void insertOrderInfo(HttpSession session, HttpServletRequest request, int userId) {
        //Insert to order table
        String receiver = request.getParameter("firstName") + " " + request.getParameter("lastName");
        String shipStreet = request.getParameter("street");
        String shipCity = request.getParameter("city");
        String shipProvince = request.getParameter("province");
        String shipCountry = request.getParameter("country");
        String shipEmail = request.getParameter("email");
        String shipPhone = request.getParameter("phone");
        String status = "Wait";
        String createdTime = java.time.LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        Order order = new Order(userId, receiver, shipStreet, shipCity, shipProvince, shipCountry, shipEmail, shipPhone, status, createdTime);
        OrderDAO odao = new OrderDAO();
        int orderId = odao.addOrder(order, true); //return id = true
        
        //Insert to orderDetail table
        Cart cart = (Cart) session.getAttribute("cart");
        OrderDetailDAO oddao = new OrderDetailDAO();
        for (CartItem item : cart.getItems()) {
            OrderDetail orderDetail = new OrderDetail(orderId, item.getProductId(), item.getProductName(), item.getPrice(), item.getQuantity());
            oddao.addOrderDetail(orderDetail);
        }
    }

    protected void clearCart(HttpSession session) {
        session.removeAttribute("cart");
        session.removeAttribute("subtotal");
        session.removeAttribute("numberOfItemsInCart");
        session.removeAttribute("shippingFee");
    }
}
