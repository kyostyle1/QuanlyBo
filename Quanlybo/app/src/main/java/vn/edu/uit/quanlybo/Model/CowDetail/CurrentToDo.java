package vn.edu.uit.quanlybo.Model.CowDetail;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import vn.edu.uit.quanlybo.Model.ListCowToDo.CowToDo;
import vn.edu.uit.quanlybo.Model.ListCowToDo.ToDo;
import vn.edu.uit.quanlybo.Model.ListCowToDo.ToDoItem;
import vn.edu.uit.quanlybo.Model.ListCowToDo.Type;


/**
 * Created by PhucHuynh on 11/27/16.
 */

public class CurrentToDo implements ParentListItem{
    private Type type;

    @SerializedName("todo")
    @Expose
    private List<ToDoDetail> toDoDetailList = new ArrayList<>();

    public CurrentToDo(Type type, List<ToDoDetail> toDoDetailList) {
        this.type = type;
        this.toDoDetailList = toDoDetailList;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<ToDoDetail> getToDoDetailList() {
        return toDoDetailList;
    }

    public void setToDoDetailList(List<ToDoDetail> toDoDetailList) {
        this.toDoDetailList = toDoDetailList;
    }

    @Override
    public List<ToDoDetail> getChildItemList() {
        return toDoDetailList;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return true;
    }
}
