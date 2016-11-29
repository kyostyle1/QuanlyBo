package vn.edu.uit.quanlybo.Network.Model;

/**
 * Created by PhucHuynh on 11/29/16.
 */

public class ToDoSuccessRequest {

    private String cow_id;
    private String day_old;
    private String todo_id;
    private String success;

    public ToDoSuccessRequest(String cow_id, String day_old, String todo_id, String success) {
        this.cow_id = cow_id;
        this.day_old = day_old;
        this.todo_id = todo_id;
        this.success = success;
    }

    public String getCow_id() {
        return cow_id;
    }

    public void setCow_id(String cow_id) {
        this.cow_id = cow_id;
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

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
