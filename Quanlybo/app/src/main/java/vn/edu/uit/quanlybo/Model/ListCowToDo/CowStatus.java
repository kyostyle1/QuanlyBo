package vn.edu.uit.quanlybo.Model.ListCowToDo;

/**
 * Created by PhucHuynh on 11/28/16.
 */

public class CowStatus {
    private int id;
    private int day_old;
    private boolean success;

    public CowStatus(int id, int day_old, boolean success) {
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

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
