package vn.edu.uit.quanlybo.Model.ListLibrary;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.List;

/**
 * Created by Jackson Nghi on 11/28/2016.
 */

public class LibraryType implements ParentListItem {

    private String id;
    private String name;
    private String description;

    private List<LibraryResponse> libraryResponseList;

    public LibraryType (String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public void setLibraryResponseList(List<LibraryResponse> libraryResponseList) {
        this.libraryResponseList = libraryResponseList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public List<LibraryResponse> getChildItemList() {
        return libraryResponseList;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return true;
    }
}
