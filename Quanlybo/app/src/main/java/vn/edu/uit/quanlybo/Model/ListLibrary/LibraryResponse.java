package vn.edu.uit.quanlybo.Model.ListLibrary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jackson Nghi on 11/28/2016.
 */

public class LibraryResponse {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("libTypeId")
    @Expose
    private String libTypeId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("content")
    @Expose
    private String content;

    public LibraryResponse(String id, String libTypeId, String title, String description, String content){
        this.id = id;
        this.libTypeId = libTypeId;
        this.title = title;
        this.description = description;
        this.content = content;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLibTypeId() {
        return libTypeId;
    }

    public void setLibTypeId(String libTypeId) {
        this.libTypeId = libTypeId;
    }

}

