package controller;

import dao.BrandDAO;
import dao.CategoryDAO;
import dao.ProductDAO;
import model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Vector;

/**
 *
 * @author Huy Nguyen
 */
public class ProductDetailsController extends HttpServlet {

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
            out.println("<title>Servlet ProductDetailsController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductDetailsController at " + request.getContextPath() + "</h1>");
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
        if (request.getParameter("proId") == null || request.getParameter("proId").equals("")) {
            response.sendRedirect("404");
        } else {
            int proId = Integer.parseInt(request.getParameter("proId"));
            ProductDAO pdao = new ProductDAO();
            Product product = pdao.getById(proId);
            if (product == null) {
                response.sendRedirect("404");
            } else {
                CategoryDAO cdao = new CategoryDAO();
                BrandDAO bdao = new BrandDAO();
                String categoryName = cdao.getById(product.getCategoryId()).getName();
                String brandName = bdao.getById(product.getBrandId()).getName();
                Vector<Product> relatedProducts = pdao.getRelatedProducts(product);
                
                request.setAttribute("categoryName", categoryName);
                request.setAttribute("brandName", brandName);
                request.setAttribute("product", product);
                request.setAttribute("relatedProducts", relatedProducts);
                request.getRequestDispatcher("/jsp/productDetailsPage.jsp").forward(request, response);
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
        processRequest(request, response);
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
