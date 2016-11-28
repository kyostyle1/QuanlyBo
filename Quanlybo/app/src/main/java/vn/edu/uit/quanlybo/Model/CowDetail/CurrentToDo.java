package vn.edu.uit.quanlybo.Model.CowDetail;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import vn.edu.uit.quanlybo.Model.ListCowToDo.ToDo;
import vn.edu.uit.quanlybo.Model.ListCowToDo.Type;


/**
 * Created by PhucHuynh on 11/27/16.
 */

public class CurrentToDo implements ParentListItem{
    private Type type;

    @SerializedName("todo")
    @Expose
    private List<ToDo> toDoList = new ArrayList<>();

    public CurrentToDo(Type type, List<ToDo> toDoList) {
        this.type = type;
        this.toDoList = toDoList;
    }

    private List<ToDo> toDoItems;


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<ToDo> getToDoList() {
        return toDoList;
    }

    public void setToDoList(List<ToDo> toDoList) {
        this.toDoList = toDoList;
    }

    @Override
    public List<ToDo> getChildItemList() {
        return toDoItems;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }
}
