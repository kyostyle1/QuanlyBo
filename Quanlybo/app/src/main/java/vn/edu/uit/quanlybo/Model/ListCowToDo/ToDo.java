package vn.edu.uit.quanlybo.Model.ListCowToDo;

/**
 * Created by PhucHuynh on 11/27/16.
 */

public class ToDo {
    private String id;
    private String title;
    private String description;
    private String content;
    private String img;
    private String success;

    public ToDo(String id, String title, String description, String content, String success) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.success = success;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
