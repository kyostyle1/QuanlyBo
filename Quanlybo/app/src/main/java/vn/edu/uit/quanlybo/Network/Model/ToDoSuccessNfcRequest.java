package vn.edu.uit.quanlybo.Network.Model;

/**
 * Created by PhucHuynh on 12/27/16.
 */

public class ToDoSuccessNfcRequest {

    private String nfc_id;
    private String day_old;
    private String todo_id;
    private String success;

    public ToDoSuccessNfcRequest(String nfc_id, String day_old, String todo_id, String success) {
        this.nfc_id = nfc_id;
        this.day_old = day_old;
        this.todo_id = todo_id;
        this.success = success;
    }

    public String getNfc_id() {
        return nfc_id;
    }

    public void setNfc_id(String nfc_id) {
        this.nfc_id = nfc_id;
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
