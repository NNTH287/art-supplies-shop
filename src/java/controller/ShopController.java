package controller;

import constant.IConstant;
import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.StringTokenizer;
import java.util.Vector;
import model.Product;
import util.Helper;

/**
 *
 * @author Huy Nguyen
 */
public class ShopController extends HttpServlet {
   
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
        ProductDAO pdao = new ProductDAO();
        int cateId = Integer.parseInt(request.getParameter("cateId") != null ? request.getParameter("cateId") : "-1");
        int brandId = Integer.parseInt(request.getParameter("brandId") != null ? request.getParameter("brandId") : "-1");
        double minPrice = 0.0;
        double maxPrice = IConstant.MAX_PRICE;
        Helper.getCategory(request);
        Helper.getBrand(request);
        
       
        if (request.getParameter("price") != null && !request.getParameter("price").equals("")) {
            StringTokenizer tokenizer = new StringTokenizer(request.getParameter("price" ), "-");
            System.out.println("got");
            minPrice = Double.parseDouble(tokenizer.nextToken());
            maxPrice = Double.parseDouble(tokenizer.nextToken());
            System.out.println("min: " + minPrice + ", max: " + maxPrice);
        }
        
        Vector<Product> products = pdao.filterProducts(cateId, brandId, minPrice, maxPrice);
        request.setAttribute("products", products);
        request.getRequestDispatcher("/jsp/shopPage.jsp").forward(request, response);
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
        
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
