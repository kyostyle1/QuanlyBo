package vn.edu.uit.quanlybo.Model.Market;

import java.util.Date;

/**
 * Created by Jackson Nghi on 12/10/2016.
 */

public class BuyCowReponse {
    private String id;
    private String title;
    private String location;
    private int price;
    private String cow_type;
    private String cow_gender;
    private String date_created;
    private int is_sold;

    public BuyCowReponse(String id,int is_sold, String title, String location, int price, String cow_type, String cow_gender, String date_created) {
        this.id = id;
        this.is_sold = is_sold;
        this.title = title;
        this.location = location;
        this.price = price;
        this.cow_type = cow_type;
        this.cow_gender = cow_gender;
        this.date_created = date_created;
    }

    public BuyCowReponse() {
    }

    public int getIs_sold() {
        return is_sold;
    }

    public void setIs_sold(int is_sold) {
        this.is_sold = is_sold;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCow_type() {
        return cow_type;
    }

    public void setCow_type(String cow_type) {
        this.cow_type = cow_type;
    }

    public String getCow_gender() {
        return cow_gender;
    }

    public void setCow_gender(String cow_gender) {
        this.cow_gender = cow_gender;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }
}
