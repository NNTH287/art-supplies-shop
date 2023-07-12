package controller;

import dao.UserDAO;
import model.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Huy Nguyen
 */
public class LoginController extends HttpServlet {
   
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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        request.getRequestDispatcher("/jsp/loginPage.jsp").forward(request, response);
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username == null || username.equals("")) {
            HttpSession session = request.getSession();
            session.setAttribute("notiType", "RED");
            session.setAttribute("notification", "Email cannot be blank!");
            doGet(request, response);
        } else if (password == null || password.equals("")){
            HttpSession session = request.getSession();
            session.setAttribute("notiType", "RED");
            session.setAttribute("notification", "Password cannot be blank!");
            doGet(request, response);
        }
        UserDAO udao = new UserDAO();
        User user = udao.getByEmail(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("userId", user.getId());
                if (user.getRole().equals("Admin")) {
                    session.setAttribute("adminUser", user.getId());
                    response.sendRedirect("admin/home");
                } else {
                    session.setAttribute("customerUser", user.getId());
                    response.sendRedirect("home");
                }
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("notiType", "RED");
                session.setAttribute("notification", "Wrong password!");destroy();
                doGet(request, response);
            }
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("notiType", "RED");
            session.setAttribute("notification", "User doesn't exists!");
            doGet(request, response);
        }
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
