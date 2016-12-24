package vn.edu.uit.quanlybo.Network.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import vn.edu.uit.quanlybo.Model.User;

/**
 * Created by phuc9 on 11/14/2016.
 */

public class UserLoginResponse {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("role")
    @Expose
    public String role;
    @SerializedName("username")
    @Expose
    public String username;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("phone")
    @Expose
    public String phone;
    @SerializedName("address")
    @Expose
    public String address;
    @SerializedName("access_token")
    @Expose
    public String accessToken;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("password")
    @Expose
    public String password;
    @SerializedName("active")
    @Expose
    public String active;
    @SerializedName("dateCreated")
    @Expose
    public String dateCreated;
    @SerializedName("dateUpdated")
    @Expose
    public String dateUpdated;

    public UserLoginResponse(String id, String role, String username, String email, String phone, String address, String accessToken, String name, String password, String active, String dateCreated, String dateUpdated) {
        this.id = id;
        this.role = role;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.accessToken = accessToken;
        this.name = name;
        this.password = password;
        this.active = active;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
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

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
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

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}