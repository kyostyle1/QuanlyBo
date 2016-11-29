package vn.edu.uit.quanlybo.Network.Model;

/**
 * Created by PhucHuynh on 11/29/16.
 */

public class ToDoHistoryResponse {

    private String day_old;
    private String todo_id;
    private String todo_title;
    private String todo_description;
    private String success;

    public ToDoHistoryResponse(String day_old, String todo_id, String todo_title, String todo_description, String success) {
        this.day_old = day_old;
        this.todo_id = todo_id;
        this.todo_title = todo_title;
        this.todo_description = todo_description;
        this.success = success;
    }

    public String getDay_old() {
        return day_old;
    }

    public void setDay_old(String day_old) {
        this.day_old = day_old;
    }

    public String getTodo_id() {
        return todo_id;
    }

    public void setTodo_id(String todo_id) {
        this.todo_id = todo_id;
    }

    public String getTodo_title() {
        return todo_title;
    }

    public void setTodo_title(String todo_title) {
        this.todo_title = todo_title;
    }

    public String getTodo_description() {
        return todo_description;
    }

    public void setTodo_description(String todo_description) {
        this.todo_description = todo_description;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
