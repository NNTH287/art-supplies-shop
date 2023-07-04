package conntroller;

import dao.CategoryDAO;
import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;
import model.Category;
import model.Product;
import java.util.Comparator;

/**
 *
 * @author Huy Nguyen
 */
public class HomeController extends HttpServlet {

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
            //Get categories ans its number of products from database
            CategoryDAO cdao = new CategoryDAO();
            Vector<Category> categoriesVector = cdao.getAll();
            Map<Category, Integer> categoriesUnsorted = new Hashtable<>();
            for (Category category : categoriesVector) {
                int numberOfProducts = cdao.getNumberOfProductsIn(category.getId());
                categoriesUnsorted.put(category, numberOfProducts);
            }
            //Sort categrories (the "Others" category be the last)
            LinkedHashMap<Category, Integer> categories = new LinkedHashMap<>();
            Comparator<Category> comparator = Comparator.comparing(
                    Category::getName, (String c1, String c2) -> {
                        if (c1.equals("Others")) {
                            return 1;
                        }
                        if (c2.equals("Others")) {
                            return -1;
                        }
                        return c1.compareTo(c2);
                    });
            categoriesUnsorted.entrySet().stream()
                    .sorted(Map.Entry.<Category, Integer>comparingByKey(comparator))
                    .forEachOrdered(e -> categories.put(e.getKey(), e.getValue()));
            
            //Get products from database
            ProductDAO pdao = new ProductDAO();
            Vector<Product> products = pdao.getAll();
            
            request.setAttribute("products", products);
            request.setAttribute("categories", categories);
            request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
    }// </editor-fold>

}
