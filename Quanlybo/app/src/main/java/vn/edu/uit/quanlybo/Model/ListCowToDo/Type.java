package vn.edu.uit.quanlybo.Model.ListCowToDo;

/**
 * Created by PhucHuynh on 11/28/16.
 */

public class Type {

    private String id;
    private String name;
    private String description;

    public Type(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
