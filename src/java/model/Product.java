package model;

public class Product {
    private int id;
    private int categoryId;
    private int brandId;
    private String name;
    private String description;
    private double price;
    private double discount;
    private int quantity;

    public Product() {
    }

    public Product(int id, int categoryId, int brandId, String name, String description, double price, double discount, int quantity) {
        this.id = id;
        this.categoryId = categoryId;
        this.brandId = brandId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{id=" + id
                + ", categoryId=" + categoryId
                + ", brandId=" + brandId
                + ", name=" + name
                + ", description=" + description
                + ", price=" + price
                + ", discount=" + discount
                + ", quantity=" + quantity;
    }
}
