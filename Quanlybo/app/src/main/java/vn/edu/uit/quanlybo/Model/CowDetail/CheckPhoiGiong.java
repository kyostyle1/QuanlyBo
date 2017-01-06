package vn.edu.uit.quanlybo.Model.CowDetail;

import java.util.List;

/**
 * Created by Jackson Nghi on 1/6/2017.
 */

public class CheckPhoiGiong {
    private boolean status;
    private List<Integer> cow;

    public CheckPhoiGiong(boolean status, List<Integer> cow) {
        this.status = status;
        this.cow = cow;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Integer> getCow() {
        return cow;
    }

    public void setCow(List<Integer> cow) {
        this.cow = cow;
    }
}
