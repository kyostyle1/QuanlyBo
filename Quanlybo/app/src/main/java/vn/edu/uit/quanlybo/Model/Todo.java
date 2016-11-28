package vn.edu.uit.quanlybo.Model;

/**
 * Created by PhucHuynh on 11/27/16.
 */

public class Todo {
    private String id;
    private String title;
    private String description;
    private String content;
    private Boolean success;

    public Todo(String id, String title, String description, String content) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
    }

    public Todo(String id, String title, String description, String content, Boolean success) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.success = success;
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

    public Boolean isSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
