package model.entity;

public class Payment {
    private int id;
    private int userId;
    private String paymentType;
    private String paymentInfo;

    public Payment() {
    }

    public Payment(int id, int userId, String paymentType, String paymentInfo) {
        this.id = id;
        this.userId = userId;
        this.paymentType = paymentType;
        this.paymentInfo = paymentInfo;
    }

    public Payment(int userId, String paymentType, String paymentInfo) {
        this.userId = userId;
        this.paymentType = paymentType;
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

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    @Override
    public String toString() {
        return "Payment{id=" + id
                + ", userId=" + userId
                + ", paymentType=" + paymentType
                + ", paymentInfo=" + paymentInfo + "}";
    }
}
