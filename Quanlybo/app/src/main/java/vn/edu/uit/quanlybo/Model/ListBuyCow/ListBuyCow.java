package vn.edu.uit.quanlybo.Model.ListBuyCow;

/**
 * Created by Jackson Nghi on 12/6/2016.
 */

public class ListBuyCow {
    String id;
    String title;
    String content;
    String address;
    String price;
    public ListBuyCow(String id, String title, String content, String address, String price){
        this.id = id;
        this.title = title;
        this.content = content;
        this.address = address;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
