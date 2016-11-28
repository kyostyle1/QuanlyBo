package vn.edu.uit.quanlybo.Model.ListCowToDo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by PhucHuynh on 11/28/16.
 */

public class CowToDo {

    @SerializedName("todo")
    @Expose
    private ToDo toDo;

    @SerializedName("cow")
    @Expose
    private List<CowStatus> cow;

    public CowToDo(ToDo toDo, List<CowStatus> cow) {
        this.toDo = toDo;
        this.cow = cow;
    }

    public ToDo getToDo() {
        return toDo;
    }

    public void setToDo(ToDo toDo) {
        this.toDo = toDo;
    }

    public List<CowStatus> getCow() {
        return cow;
    }

    public void setCow(List<CowStatus> cow) {
        this.cow = cow;
    }
}
