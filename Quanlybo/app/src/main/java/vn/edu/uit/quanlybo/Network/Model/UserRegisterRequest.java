package vn.edu.uit.quanlybo.Network.Model;

/**
 * Created by phuc9 on 11/14/2016.
 */

public class UserRegisterRequest {
    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String name;

    public UserRegisterRequest(String username, String password, String email, String phone, String address, String name) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.name = name;
    }

    public UserRegisterRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
