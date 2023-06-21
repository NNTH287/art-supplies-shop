package model;

public class UserPayment {
    private int id;
    private int userId;
    private String paymentInfo;

    public UserPayment() {
    }

    public UserPayment(int id, int userId, String paymentType, String paymentInfo) {
        this.id = id;
        this.userId = userId;
        this.paymentInfo = paymentInfo;
    }

    public UserPayment(int userId, String paymentType, String paymentInfo) {
        this.userId = userId;
        this.paymentInfo = paymentInfo;
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

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    @Override
    public String toString() {
        return "UserPayment{id=" + id
                + ", userId=" + userId
                + ", paymentInfo=" + paymentInfo + "}";
    }
}
