package vn.edu.uit.quanlybo.Model.ListCowToDo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PhucHuynh on 11/28/16.
 */

public class ToDoItem {
    private String title;
    private List<String> cowId;

    public ToDoItem(String title, List<String> cowId) {
        this.title = title;
        this.cowId = cowId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getCowId() {
        return cowId;
    }

    public void setCowId(List<String> cowId) {
        this.cowId = cowId;
    }
}
