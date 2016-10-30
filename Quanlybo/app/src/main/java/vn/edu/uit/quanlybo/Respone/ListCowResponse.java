package vn.edu.uit.quanlybo.Respone;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import vn.edu.uit.quanlybo.Model.Cow;

/**
 * Created by phuc9 on 10/28/2016.
 */
public class ListCowResponse {

    @SerializedName("Cow")
    @Expose
    public List<Cow> cow = new ArrayList<Cow>();
    @SerializedName("_links")
    @Expose
    public Links links;
    @SerializedName("_meta")
    @Expose
    public Meta meta;

    public List<Cow> getCow() {
        return cow;
    }

    public void setCow(List<Cow> cow) {
        this.cow = cow;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    @Override
    public String toString() {
        return "ListCowResponse{" +
                "cow=" + cow +
                ", links=" + links +
                ", meta=" + meta +
                '}';
    }
}
