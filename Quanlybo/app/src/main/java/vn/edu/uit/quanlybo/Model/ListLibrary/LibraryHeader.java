package vn.edu.uit.quanlybo.Model.ListLibrary;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.List;

/**
 * Created by Jackson Nghi on 11/28/2016.
 */

public class LibraryHeader implements ParentListItem {
    private String title;



    private List<LibraryItem> libraryItems;

    public LibraryHeader(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<LibraryItem> getLibraryItems() {
        return libraryItems;
    }

    public void setLibraryItems(List<LibraryItem> libraryItems) {
        this.libraryItems = libraryItems;
    }

    @Override
    public List<LibraryItem> getChildItemList() {
        return libraryItems;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }
}
