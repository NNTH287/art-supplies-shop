package model;

public class Order {
    private int id;
    private int userId;
    private String receiver;
    private String shipStreet;
    private String shipCity;
    private String shipProvince;
    private String shipCountry;
    private String shipEmail;
    private String shipPhone;
    private String status;
    private String createdTime;

    public Order() {
    }

    public Order(int id, int userId, String receiver, String shipStreet, String shipCity, String shipProvince, String shipCountry, String shipEmail, String shipPhone, String status, String createdTime) {
        this.id = id;
        this.userId = userId;
        this.receiver = receiver;
        this.shipStreet = shipStreet;
        this.shipCity = shipCity;
        this.shipProvince = shipProvince;
        this.shipCountry = shipCountry;
        this.shipEmail = shipEmail;
        this.shipPhone = shipPhone;
        this.status = status;
        this.createdTime = createdTime;
    }
    
    public Order(int userId, String receiver, String shipStreet, String shipCity, String shipProvince, String shipCountry, String shipEmail, String shipPhone, String status, String createdTime) {
        this.userId = userId;
        this.receiver = receiver;
        this.shipStreet = shipStreet;
        this.shipCity = shipCity;
        this.shipProvince = shipProvince;
        this.shipCountry = shipCountry;
        this.shipEmail = shipEmail;
        this.shipPhone = shipPhone;
        this.status = status;
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

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getShipStreet() {
        return shipStreet;
    }

    public void setShipStreet(String shipStreet) {
        this.shipStreet = shipStreet;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipProvince() {
        return shipProvince;
    }

    public void setShipProvince(String shipProvince) {
        this.shipProvince = shipProvince;
    }

    public String getShipCountry() {
        return shipCountry;
    }

    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
    }

    public String getShipEmail() {
        return shipEmail;
    }

    public void setShipEmail(String shipEmail) {
        this.shipEmail = shipEmail;
    }

    public String getShipPhone() {
        return shipPhone;
    }

    public void setShipPhone(String shipPhone) {
        this.shipPhone = shipPhone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "Order{ id=" + id
                + ", userId=" + userId
                + ", receiver=" + receiver
                + ", shipStreet=" + shipStreet
                + ", shipCity=" + shipCity
                + ", shipProvince=" + shipProvince
                + ", shipCountry=" + shipCountry
                + ", shipEmail=" + shipEmail
                + ", shipPhone=" + shipPhone
                + ", status=" + status
                + ", createdTime=" + createdTime + "}";
    }
}
