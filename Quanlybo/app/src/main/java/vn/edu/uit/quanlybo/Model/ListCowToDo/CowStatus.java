package vn.edu.uit.quanlybo.Model.ListCowToDo;

/**
 * Created by PhucHuynh on 11/28/16.
 */

public class CowStatus {
    private int id;
    private int day_old;
    private String success;

    public CowStatus(int id, int day_old, String success) {
        this.id = id;
        this.day_old = day_old;
        this.success = success;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDay_old() {
        return day_old;
    }

    public void setDay_old(int day_old) {
        this.day_old = day_old;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
