package vn.edu.uit.quanlybo.Model.Market;

import java.util.List;

/**
 * Created by Jackson Nghi on 12/14/2016.
 */

public class DetailsBuyCows {

    private String id;
    private String userId;
    private String cowId;
    private String title;
    private String name;
    private String phone;
    private String location;
    private String content;
    private int price;
    private int is_sold;
    private String dateCreated;
    private String dateUpdated;
    private String cow_type_name;
    private String cow_target_name;
    private String cow_gender_name;
    private String cow_birthday;
    private String cow_day_old;
    private List<History_Cow> cow_history_todo;

    public DetailsBuyCows(String id, String userId ,String cowId, String title, String name, String phone, String location, String content, int price, int is_sold, String dateCreated, String dateUpdated, String cow_type_name, String cow_target_name, String cow_gender_name, String cow_birthday, String cow_day_old, List<History_Cow> cow_history_todo) {
        this.id = id;
        this.userId = userId;
        this.cowId = cowId;
        this.title = title;
        this.name = name;
        this.phone = phone;
        this.location = location;
        this.content = content;
        this.price = price;
        this.is_sold = is_sold;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.cow_type_name = cow_type_name;
        this.cow_target_name = cow_target_name;
        this.cow_gender_name = cow_gender_name;
        this.cow_birthday = cow_birthday;
        this.cow_day_old = cow_day_old;
        this.cow_history_todo = cow_history_todo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getIs_sold() {
        return is_sold;
    }

    public void setIs_sold(int is_sold) {
        this.is_sold = is_sold;
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

    public String getCow_type_name() {
        return cow_type_name;
    }

    public void setCow_type_name(String cow_type_name) {
        this.cow_type_name = cow_type_name;
    }

    public String getCow_target_name() {
        return cow_target_name;
    }

    public void setCow_target_name(String cow_target_name) {
        this.cow_target_name = cow_target_name;
    }

    public String getCow_gender_name() {
        return cow_gender_name;
    }

    public void setCow_gender_name(String cow_gender_name) {
        this.cow_gender_name = cow_gender_name;
    }

    public String getCow_birthday() {
        return cow_birthday;
    }

    public void setCow_birthday(String cow_birthday) {
        this.cow_birthday = cow_birthday;
    }

    public String getCow_day_old() {
        return cow_day_old;
    }

    public void setCow_day_old(String cow_day_old) {
        this.cow_day_old = cow_day_old;
    }

    public List<History_Cow> getListHistoryCow() {
        return cow_history_todo;
    }

    public void setListHistoryCow(List<History_Cow> cow_history_todo) {
        this.cow_history_todo = cow_history_todo;
    }
}
