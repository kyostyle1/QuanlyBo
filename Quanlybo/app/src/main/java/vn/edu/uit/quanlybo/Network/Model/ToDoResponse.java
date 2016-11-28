package vn.edu.uit.quanlybo.Network.Model;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import vn.edu.uit.quanlybo.Model.ListCowToDo.CowToDo;
import vn.edu.uit.quanlybo.Model.ListCowToDo.ToDoItem;
import vn.edu.uit.quanlybo.Model.ListCowToDo.Type;

/**
 * Created by PhucHuynh on 11/28/16.
 */

public class ToDoResponse implements ParentListItem {

    @SerializedName("type")
    @Expose
    public Type type;

    @SerializedName("cow_todo")
    @Expose
    public List<CowToDo> cow_todo = new ArrayList<>();

    public ToDoResponse(Type type, List<CowToDo> cow_todo) {
        this.type = type;
        this.cow_todo = cow_todo;
    }

    private List<CowToDo> toDoItems;


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<CowToDo> getCow_todo() {
        return cow_todo;
    }

    public void setCow_todo(List<CowToDo> cow_todo) {
        this.cow_todo = cow_todo;
    }

    @Override
    public List<CowToDo> getChildItemList() {
        return toDoItems;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return true;
    }

    public void setToDoItems(List<CowToDo> toDoItems) {
        this.toDoItems = toDoItems;
    }

}
