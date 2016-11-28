package vn.edu.uit.quanlybo.Model.ListLibrary;

import java.util.List;

/**
 * Created by Jackson Nghi on 11/28/2016.
 */

public class LibratyToDo  {

    private LibraryType libraryType;

    private List<LibraryResponse> libraryResponse;

    public LibratyToDo(LibraryType libraryType, List<LibraryResponse> libraryResponse) {
        this.libraryType = libraryType;
        this.libraryResponse = libraryResponse;
    }
    public LibraryType getLibraryType() {
        return libraryType;
    }

    public void setLibraryType(LibraryType libraryType) {
        this.libraryType = libraryType;
    }

    public List<LibraryResponse> getLibraryResponse() {
        return libraryResponse;
    }

    public void setLibraryResponse(List<LibraryResponse> libraryResponse) {
        this.libraryResponse = libraryResponse;
    }

}

