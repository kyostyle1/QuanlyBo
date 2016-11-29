package vn.edu.uit.quanlybo.Network.Model;

/**
 * Created by PhucHuynh on 11/29/16.
 */

public class CowTypeResponse {
    private String id;
    private String name;
    private String description;
    private String content;

    public CowTypeResponse(String id, String name, String description, String content) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
