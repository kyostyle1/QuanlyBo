package vn.edu.uit.quanlybo.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by phuc9 on 10/24/2016.
 */
public class User {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("access_token")
    @Expose
    private String access_token;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("active")
    @Expose
    private int active;
    @SerializedName("dateCreated")
    @Expose
    private String dateCreated;
    @SerializedName("dateUpdated")
    @Expose
    private String dateUpdated;


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
        this.login = user.login;
        this.email = user.email;
        this.address = user.address;
        this.access_token = user.access_token;
        this.name = user.name;
        this.password = user.password;
        this.active = user.active;
        this.dateCreated = user.dateCreated;
        this.dateUpdated = user.dateUpdated;
    }

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The role
     */
    public String getRole() {
        return role;
    }

    /**
     *
     * @param role
     * The role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     *
     * @return
     * The login
     */
    public String getLogin() {
        return login;
    }

    /**
     *
     * @param login
     * The login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     *
     * @return
     * The email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     * The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     * The address
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     * The address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     * The password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     * The active
     */
    public int getActive() {
        return active;
    }

    /**
     *
     * @param active
     * The active
     */
    public void setActive(int active) {
        this.active = active;
    }

    /**
     *
     * @return
     * The dateCreated
     */
    public Object getDateCreated() {
        return dateCreated;
    }

    /**
     *
     * @param dateCreated
     * The dateCreated
     */
    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     *
     * @return
     * The dateUpdated
     */
    public Object getDateUpdated() {
        return dateUpdated;
    }

    /**
     *
     * @param dateUpdated
     * The dateUpdated
     */
    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }


    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
}