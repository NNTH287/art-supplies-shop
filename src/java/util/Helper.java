package util;

import dao.BrandDAO;
import dao.CategoryDAO;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;
import model.Brand;
import model.Category;

public class Helper {

    /**
     * Block from creating instance
     */
    private Helper() {
    }

    public static void getCategory(HttpServletRequest request) {
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

    public static void getBrand(HttpServletRequest request) {
        //Get brands ans its number of products from database
        BrandDAO bdao = new BrandDAO();
        Vector<Brand> brandsVector = bdao.getAll();
        Map<Brand, Integer> brandsUnsorted = new Hashtable<>();
        for (Brand brand : brandsVector) {
            int numberOfProducts = bdao.getNumberOfProductsIn(brand.getId());
            brandsUnsorted.put(brand, numberOfProducts);
        }
        //Sort brands (the "Nobrand" category be the last)
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
}
