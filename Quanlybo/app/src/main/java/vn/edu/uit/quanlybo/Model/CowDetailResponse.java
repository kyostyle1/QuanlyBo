package vn.edu.uit.quanlybo.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PhucHuynh on 11/27/16.
 */

public class CowDetailResponse {

    private Cow cow;
    private List<CurrentToDo> currentToDoList = new ArrayList<>();


    public CowDetailResponse(Cow cow, List<CurrentToDo> currentToDoList) {
        this.cow = cow;
        this.currentToDoList = currentToDoList;
    }


    public Cow getCow() {
        return cow;
    }

    public void setCow(Cow cow) {
        this.cow = cow;
    }

    public List<CurrentToDo> getCurrentToDoList() {
        return currentToDoList;
    }

    public void setCurrentToDoList(List<CurrentToDo> currentToDoList) {
        this.currentToDoList = currentToDoList;
    }
}
