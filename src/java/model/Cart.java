package model;

import java.util.Vector;

public class Cart {
    private int id;
    private int userId;
    private String sessionId;
    private Vector<CartItem> items;

    public Cart() {
    }

    public Cart(int id, int userId, String sessionId, Vector<CartItem> items) {
        this.id = id;
        this.userId = userId;
        this.sessionId = sessionId;
        this.items = items;
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

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Vector<CartItem> getItems() {
        return items;
    }

    public void setItems(Vector<CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{id=" + id
                + ", userId=" + userId
                + ", sessionId=" + sessionId + "}";
    }
}
