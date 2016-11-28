package vn.edu.uit.quanlybo.Model.ListLibrariesToDo;

/**
 * Created by Jackson Nghi on 11/28/2016.
 */

public class LibraryType  {

    private String id;
    private String name;
    private String description;


    public LibraryType (String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;


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





}
