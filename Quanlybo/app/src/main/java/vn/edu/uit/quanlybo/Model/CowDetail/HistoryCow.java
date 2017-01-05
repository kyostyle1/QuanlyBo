package vn.edu.uit.quanlybo.Model.CowDetail;

/**
 * Created by Jackson Nghi on 1/5/2017.
 */

public class HistoryCow {
    private String id;
    private String username;
    private String date_created;

    public HistoryCow(String id, String username, String date_created) {
        this.id = id;
        this.date_created = date_created;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }
}
