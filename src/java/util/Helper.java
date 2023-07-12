package util;

import dao.BrandDAO;
import dao.CategoryDAO;
import dao.UserDAO;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;
import model.Brand;
import model.Category;
import model.User;

public class Helper {

    /**
     * Block from creating instance
     */
    private Helper() {
    }

    /**
     * Get all categories and its number of products from the database, sort
     * alphabetically the result (the "Others" category be the last) then set it
     * to request attribute.
     *
     * @param request servlet request
     */
    public static void getCategory(HttpServletRequest request) {
        CategoryDAO cdao = new CategoryDAO();
        Vector<Category> categoriesVector = cdao.getAll();
        Map<Category, Integer> categoriesUnsorted = new Hashtable<>();
        for (Category category : categoriesVector) {
            int numberOfProducts = cdao.getNumberOfProductsIn(category.getId());
            categoriesUnsorted.put(category, numberOfProducts);
        }
        
        LinkedHashMap<Category, Integer> categories = new LinkedHashMap<>();
        Comparator<Category> categoryComparator = Comparator.comparing(
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
                .sorted(Map.Entry.<Category, Integer>comparingByKey(categoryComparator))
                .forEachOrdered(e -> categories.put(e.getKey(), e.getValue()));

        request.setAttribute("categories", categories);
    }

    /**
     * Get all brands and its number of products from the database, sort
     * alphabetically the result (the "Nobrand" brand be the last) then set it
     * to request attribute.
     *
     * @param request servlet request
     */
    public static void getBrand(HttpServletRequest request) {
        BrandDAO bdao = new BrandDAO();
        Vector<Brand> brandsVector = bdao.getAll();
        Map<Brand, Integer> brandsUnsorted = new Hashtable<>();
        for (Brand brand : brandsVector) {
            int numberOfProducts = bdao.getNumberOfProductsIn(brand.getId());
            brandsUnsorted.put(brand, numberOfProducts);
        }
        
        LinkedHashMap<Brand, Integer> brands = new LinkedHashMap<>();
        Comparator<Brand> brandComparator = Comparator.comparing(
                Brand::getName, (String c1, String c2) -> {
                    if (c1.equals("Nobrand")) {
                        return 1;
                    }
                    if (c2.equals("Nobrand")) {
                        return -1;
                    }
                    return c1.compareTo(c2);
                });
        brandsUnsorted.entrySet().stream()
                .sorted(Map.Entry.<Brand, Integer>comparingByKey(brandComparator))
                .forEachOrdered(e -> brands.put(e.getKey(), e.getValue()));
        
        request.setAttribute("brands", brands);
    }
    
    public static boolean createAccount(HttpServletRequest request, String role) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String province = request.getParameter("province");
        String country = request.getParameter("country");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        User user = new User(role, firstName, lastName, street, city, province, country, email, password, phone);
        UserDAO udao = new UserDAO();
        return udao.addUser(user) == 1;
    }
    
    public static int createAccount(HttpServletRequest request, String role, boolean returnId) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String province = request.getParameter("province");
        String country = request.getParameter("country");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        User user = new User(role, firstName, lastName, street, city, province, country, email, password, phone);
        UserDAO udao = new UserDAO();
        return udao.addUser(user, true);
    }
}
