package vn.edu.uit.quanlybo.Model.ListLibrariesToDo;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.List;

/**
 * Created by Jackson Nghi on 11/28/2016.
 */

public class LibraryToDoHeader implements ParentListItem {
    private String title;



    private List<LibraryToDoItem> libraryToDoItems ;

    public LibraryToDoHeader(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<LibraryToDoItem> getLibraryToDoItems() {
        return libraryToDoItems;
    }

    public void setLibraryToDoItems(List<LibraryToDoItem> libraryToDoItems) {
        this.libraryToDoItems = libraryToDoItems;
    }

    @Override
    public List<LibraryToDoItem> getChildItemList() {
        return libraryToDoItems;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }
}
