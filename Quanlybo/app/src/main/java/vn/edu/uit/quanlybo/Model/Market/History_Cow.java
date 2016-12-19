package vn.edu.uit.quanlybo.Model.Market;

/**
 * Created by Jackson Nghi on 12/14/2016.
 */

public class History_Cow {
    private String todo_id;
    private String success;
    private String title;
    private String description;


    public History_Cow(String todo_id, String success, String title, String description) {
        this.todo_id = todo_id;
        this.success = success;
        this.title = title;
        this.description = description;
    }

    public String getId() {
        return todo_id;
    }

    public void setId(String id) {
        this.todo_id = todo_id;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
