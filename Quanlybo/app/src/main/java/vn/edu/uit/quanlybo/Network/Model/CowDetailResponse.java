package vn.edu.uit.quanlybo.Network.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import vn.edu.uit.quanlybo.Model.Cow;
import vn.edu.uit.quanlybo.Model.CowDetail.CurrentToDo;

/**
 * Created by PhucHuynh on 11/27/16.
 */

public class CowDetailResponse {
    @SerializedName("cow")
    @Expose
    private Cow cow;

    @SerializedName("current_todo")
    @Expose
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
