package vn.edu.uit.quanlybo.Network.Model;

import java.util.Date;

/**
 * Created by phuc9 on 11/14/2016.
 */

public class UserRegisterResponse {
    private String id;
    private String role;
    private String username;
    private String email;
    private String phone;
    private String address;
    private String access_token;
    private String name;
    private String password;
    private int active;
    private Date dateCreated;
    private Date dateUpdated;

    public UserRegisterResponse(String id, String role, String username, String email, String phone, String address, String access_token, String name, String password, int active, Date dateCreated, Date dateUpdated) {
        this.id = id;
        this.role = role;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.access_token = access_token;
        this.name = name;
        this.password = password;
        this.active = active;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public UserRegisterResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}
