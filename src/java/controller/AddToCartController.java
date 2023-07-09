package controller;

import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Vector;
import model.Cart;
import model.CartItem;
import model.Product;

/**
 *
 * @author Huy Nguyen
 */
public class AddToCartController extends HttpServlet {

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
            out.println("<title>Servlet AddToCartController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddToCartController at " + request.getContextPath() + "</h1>");
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
        doPost(request, response);
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
        if (request.getParameter("proId") == null || request.getParameter("proId").equals("")) {
            response.sendRedirect("404");
        } else {
            int proId = Integer.parseInt(request.getParameter("proId"));
            ProductDAO pdao = new ProductDAO();
            Product product = pdao.getById(proId);
            if (product == null) {
                response.sendRedirect("404");
            } else {
                HttpSession session = request.getSession();
                int quantityToBuy = Integer.parseInt(request.getParameter("quantityToBuy") != null ? request.getParameter("quantityToBuy") : "1");
                Cart cart = (Cart) session.getAttribute("cart");
                if (cart == null) {
                    cart = new Cart(1, -1, session.getId(), new Vector());
                }
                boolean proExisted = false;
                if (!cart.getItems().isEmpty()) { //If cart is not empty
                    for (CartItem item : cart.getItems()) {
                        if (item.getProductId() == proId) { //If product already exists in the cart
                            proExisted = true;
                            item.setQuantity(item.getQuantity() + quantityToBuy);
                            break;
                        }
                    }
                }
                if (!proExisted) { //If product is not exists in the cart
                    CartItem cartItem = new CartItem(
                            cart.getItems().size() + 1, 1, proId, product.getName(), 
                            product.getPrice() * (1-product.getDiscount()), quantityToBuy
                    );
                    cart.getItems().add(cartItem);
                }
                int numberOfItemsInCart = 0;
                double subtotal = 0;
                for (CartItem item : cart.getItems()) {
                    numberOfItemsInCart += item.getQuantity();
                    subtotal += item.getPrice() * item.getQuantity();
                }
                
                session.setAttribute("notification", quantityToBuy + " of " + product.getName() + " was added to the Shopping Cart.");
                session.setAttribute("cart", cart);
                session.setAttribute("subtotal", subtotal);
                session.setAttribute("numberOfItemsInCart", numberOfItemsInCart);
                session.setAttribute("shippingFee", numberOfItemsInCart * 5000);
                response.sendRedirect("home");
            }
        }
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

}
