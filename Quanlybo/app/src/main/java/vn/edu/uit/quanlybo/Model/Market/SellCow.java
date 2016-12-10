package vn.edu.uit.quanlybo.Model.Market;

/**
 * Created by Jackson Nghi on 12/6/2016.
 */

public class SellCow {

    public SellCow() {
    }

    private String userId;
    private String cowId;
    private String title;
    private String name;
    private String phone;
    private String location;
    private String content;
    private int price;

    public SellCow(String userId, String cowId, String title, String name, String phone, String location, String content, int price) {
        this.userId = userId;
        this.cowId = cowId;
        this.title = title;
        this.name = name;
        this.phone = phone;
        this.location = location;
        this.content = content;
        this.price = price;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCowId() {
        return cowId;
    }

    public void setCowId(String cowId) {
        this.cowId = cowId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
