package vn.edu.uit.quanlybo.Model.ListLibrary;

import java.util.List;

/**
 * Created by Jackson Nghi on 11/28/2016.
 */

public class LibraryItem {
    private String title;
    private List<String> libraryContent;
    private List<String> libraryDesciption;
    public List<String> getLibraryContent() {
        return libraryContent;
    }

    public void setLibraryContent(List<String> libraryContent) {
        this.libraryContent = libraryContent;
    }



    public List<String> getLibraryDesciption() {
        return libraryDesciption;
    }

    public void setLibraryDesciption(List<String> libraryDesciption) {
        this.libraryDesciption = libraryDesciption;
    }




    public LibraryItem(String title, List<String> libraryContent, List<String> libraryDesciption) {
        this.title = title;
        this.libraryContent = libraryContent;
        this.libraryDesciption = libraryDesciption;
    }


}
