package model;

public class User {
    private int id;
    private String role;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String province;
    private String country;
    private String email;
    private String password;
    private String phone;

    public User() {
    }

    public User(int id, String role, String firstName, String lastName, String street, String city, String province, String country, String email, String password, String phone) {
        this.id = id;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.province = province;
        this.country = country;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public User(String role, String firstName, String lastName, String street, String city, String province, String country, String email, String password, String phone) {
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.province = province;
        this.country = country;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{id=" + id
                + ", role=" + role
                + ", firstName=" + firstName
                + ", lastName=" + lastName
                + ", email=" + email
                + ", password=" + password
                + ", phone=" + phone + "}";
    }
}
