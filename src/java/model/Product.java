package model;

public class Product {
    private int id;
    private int categoryId;
    private int supplierId;
    private String name;
    private String description;
    private double price;
    private double discount;
    private int quantity;

    public Product() {
    }

    public Product(int id, int categoryId, int supplierId, String name, String description, double price, double discount, int quantity) {
        this.id = id;
        this.categoryId = categoryId;
        this.supplierId = supplierId;
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

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
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
                + ", supplierId=" + supplierId
                + ", name=" + name
                + ", description=" + description
                + ", price=" + price
                + ", discount=" + discount
                + ", quantity=" + quantity;
    }
}
