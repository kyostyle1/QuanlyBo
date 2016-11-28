package vn.edu.uit.quanlybo.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by phuc9 on 10/24/2016.
 */
public class User {

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
    public Object name;
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

    private static User mInstance = null;

    private User(){
    }

    public static User getInstance(){
        if(mInstance == null)
        {
            mInstance = new User();
        }
        return mInstance;
    }

    public void setUser(User user) {
        this.id = user.id;
        this.role = user.role;
        this.username = user.username;
        this.email = user.email;
        this.address = user.address;
        this.accessToken = user.accessToken;
        this.name = user.name;
        this.password = user.password;
        this.active = user.active;
        this.dateCreated = user.dateCreated;
        this.dateUpdated = user.dateUpdated;
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

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
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