package model.entity;

public class Order {
    private int id;
    private int userId;
    private String createdTime;

    public Order() {
    }

    public Order(int id, int userId, String createdTime) {
        this.id = id;
        this.userId = userId;
        this.createdTime = createdTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
}
