package vn.edu.uit.quanlybo.Model.ListCowToDo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import vn.edu.uit.quanlybo.Model.Todo;

/**
 * Created by PhucHuynh on 11/28/16.
 */

public class CowToDo {

    private Todo todo;

    @SerializedName("cow")
    @Expose
    private List<CowStatus> cow;

    public CowToDo(Todo todo, List<CowStatus> cow) {
        this.todo = todo;
        this.cow = cow;
    }

    public Todo getTodo() {
        return todo;
    }

    public void setTodo(Todo todo) {
        this.todo = todo;
    }

    public List<CowStatus> getCow() {
        return cow;
    }

    public void setCow(List<CowStatus> cow) {
        this.cow = cow;
    }
}
