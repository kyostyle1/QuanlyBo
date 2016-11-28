package vn.edu.uit.quanlybo.Model.ListCowToDo;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.List;

/**
 * Created by PhucHuynh on 11/28/16.
 */

public class ToDoHeader implements ParentListItem {
    private String title;
    private List<ToDoItem> toDoItems;

    public ToDoHeader(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ToDoItem> getToDoItems() {
        return toDoItems;
    }

    public void setToDoItems(List<ToDoItem> toDoItems) {
        this.toDoItems = toDoItems;
    }

    @Override
    public List<ToDoItem> getChildItemList() {
        return toDoItems;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }
}
