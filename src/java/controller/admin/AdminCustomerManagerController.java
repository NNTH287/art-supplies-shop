package controller.admin;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Vector;
import model.User;
import util.Helper;

/**
 *
 * @author Huy Nguyen
 */
public class AdminCustomerManagerController extends HttpServlet {

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
            out.println("<title>Servlet AdminCustomerManagerController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminCustomerManagerController at " + request.getContextPath() + "</h1>");
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
        String service = request.getParameter("go");
        if (service == null || service.equals("")) {
            service = "displayAll";
        }
        if (service.equals("displayAll")) {
            UserDAO udao = new UserDAO();
            Vector<User> users = udao.getAll();
            request.setAttribute("users", users);
            
            request.getRequestDispatcher("/jsp/adminCustomerManagerPage.jsp").forward(request, response);
        } else if (service.equals("update")) {
            if (!isUserExists(request)) {
                Helper.setNotification(request, "User doesn't exists!", "RED");
            } else {
                UserDAO udao = new UserDAO();
                int userId = Integer.parseInt(request.getParameter("id"));
                User userToUpdate = udao.getById(userId);
                request.setAttribute("userToUpdate", userToUpdate);
                
                request.getRequestDispatcher("/jsp/adminCustomerManagerPage.jsp").forward(request, response);
            }
        } else if (service.equals("delete")) {
            if (!isUserExists(request)) {
                Helper.setNotification(request, "User doesn't exists!", "RED");
            } else {
                UserDAO udao = new UserDAO();
                int userId = Integer.parseInt(request.getParameter("id"));
                HttpSession session = request.getSession();
                if (userId == (Integer)session.getAttribute("adminUser")) {
                    Helper.setNotification(request, "You cannot delete your-self!", "RED");
                } else {
                    User userToDelete = udao.getById(userId);
                    udao.deleteUser(userToDelete);
                }
                response.sendRedirect("customer-manager");
            }
        }
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
        UserDAO udao = new UserDAO();
        if (request.getParameter("adminSearchCustomerSubmit") != null) {
            String keyword = request.getParameter("searchName");
            Vector<User> users = udao.getByName(keyword);
            
            request.setAttribute("users", users);
            request.getRequestDispatcher("/jsp/adminCustomerManagerPage.jsp").forward(request, response);
        } else if (request.getParameter("adminCustomerUpdateSubmit") != null) {
            int id = Integer.parseInt(request.getParameter("userToUpdateId"));
            String role = request.getParameter("role");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String street = request.getParameter("street");
            String city = request.getParameter("city");
            String province = request.getParameter("province");
            String country = request.getParameter("country");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String phone = request.getParameter("phone");
            User userToUpdate = new User(id, role, firstName, lastName, street, city, province, country, email, password, phone);
            udao.updateUser(userToUpdate);
        }
        response.sendRedirect("customer-manager");
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

    private boolean isUserExists(HttpServletRequest request) {
        if (request.getParameter("id") == null) {
            return false;
        } else {
            int userId = Integer.parseInt(request.getParameter("id"));
            UserDAO udao = new UserDAO();
            return udao.getById(userId) != null;
        }
    }
}
