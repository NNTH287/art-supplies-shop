package controller.admin;

import dao.BrandDAO;
import dao.CategoryDAO;
import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Vector;
import model.Brand;
import model.Category;
import model.Product;
import util.Helper;

/**
 *
 * @author Huy Nguyen
 */
public class AdminProductManagerController extends HttpServlet {
   
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
            out.println("<title>Servlet AdminProductManagerController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminProductManagerController at " + request.getContextPath () + "</h1>");
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
        String service = request.getParameter("go");
        CategoryDAO cdao = new CategoryDAO();
        Vector<Category> categories = cdao.getAll();
        request.setAttribute("categories", categories);
        BrandDAO bdao = new BrandDAO();
        Vector<Brand> brands = bdao.getAll();
        request.setAttribute("brands", brands);
        
        if (service == null || service.equals("")) {
            service = "displayAll";
        }
        if (service.equals("displayAll")) {
            ProductDAO pdao = new ProductDAO();
            Vector<Product> products = pdao.getAll();
            request.setAttribute("products", products);
            
            request.getRequestDispatcher("/jsp/adminProductManagerPage.jsp").forward(request, response);
        } else if (service.equals("update")) {
            if (!isProductExists(request)) {
                Helper.setNotification(request, "Product doesn't exists!", "RED");
            } else {
                ProductDAO pdao = new ProductDAO();
                int productId = Integer.parseInt(request.getParameter("id"));
                Product productToUpdate = pdao.getById(productId);
                request.setAttribute("productToUpdate", productToUpdate);
                
                request.getRequestDispatcher("/jsp/adminProductManagerPage.jsp").forward(request, response);
            }
        } else if (service.equals("delete")) {
            if (!isProductExists(request)) {
                Helper.setNotification(request, "Product doesn't exists!", "RED");
            } else {
                ProductDAO pdao = new ProductDAO();
                int productId = Integer.parseInt(request.getParameter("id"));
                Product productToDelete = pdao.getById(productId);
                pdao.deleteProduct(productToDelete);
                
                response.sendRedirect("product-manager");
            }
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
        ProductDAO pdao = new ProductDAO();
        if (request.getParameter("adminSearchProductSubmit") != null) {
            String keyword = request.getParameter("searchName");
            Vector<Product> products = pdao.getByName(keyword);
            CategoryDAO cdao = new CategoryDAO();
            Vector<Category> categories = cdao.getAll();
            BrandDAO bdao = new BrandDAO();
            Vector<Brand> brands = bdao.getAll();
            
            request.setAttribute("categories", categories);
            request.setAttribute("brands", brands);
            request.setAttribute("products", products);
            request.getRequestDispatcher("/jsp/adminProductManagerPage.jsp").forward(request, response);
        } else if (request.getParameter("adminProductUpdateSubmit") != null) {
            int id = Integer.parseInt(request.getParameter("productToUpdateId"));            
            int categoryId = Integer.parseInt(request.getParameter("categoryId"));
            int brandId = Integer.parseInt(request.getParameter("brandId"));
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            double price = Double.parseDouble(request.getParameter("price"));
            double discount = Double.parseDouble(request.getParameter("discount"));
            discount /= 100;
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            Product productToUpdate = new Product(id, categoryId, brandId, name, description, price, discount, quantity);
            pdao.updateProduct(productToUpdate);
            
            response.sendRedirect("product-manager");
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

    private boolean isProductExists(HttpServletRequest request) {
        if (request.getParameter("id") == null) {
            return false;
        } else {
            int productId = Integer.parseInt(request.getParameter("id"));
            ProductDAO pdao = new ProductDAO();
            return pdao.getById(productId) != null;
        }
    }
}
