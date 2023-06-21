package model;

public class Cart {
    private int id;
    private int userId;
    private int sessionId;

    public Cart() {
    }

    public Cart(int id, int userId, int sessionId) {
        this.id = id;
        this.userId = userId;
        this.sessionId = sessionId;
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

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
