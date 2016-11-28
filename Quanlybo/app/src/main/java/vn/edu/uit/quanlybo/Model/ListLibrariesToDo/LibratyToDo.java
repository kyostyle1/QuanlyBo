package vn.edu.uit.quanlybo.Model.ListLibrariesToDo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Jackson Nghi on 11/28/2016.
 */

public class LibratyToDo  {

    private LibraryType libraryType;

    private List<Library> library;

    public LibratyToDo(LibraryType libraryType, List<Library> library) {
        this.libraryType = libraryType;
        this.library = library;
    }
    public LibraryType getLibraryType() {
        return libraryType;
    }

    public void setLibraryType(LibraryType libraryType) {
        this.libraryType = libraryType;
    }

    public List<Library> getLibrary() {
        return library;
    }

    public void setLibrary(List<Library> library) {
        this.library = library;
    }

}

