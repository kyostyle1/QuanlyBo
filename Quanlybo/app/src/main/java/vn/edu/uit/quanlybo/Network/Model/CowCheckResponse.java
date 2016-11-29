package vn.edu.uit.quanlybo.Network.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by PhucHuynh on 11/29/16.
 */

public class CowCheckResponse {
    private Boolean status;

    @SerializedName("cow")
    @Expose
    private List<String> cow;

    public CowCheckResponse(Boolean status, List<String> cow) {
        this.status = status;
        this.cow = cow;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<String> getCow() {
        return cow;
    }

    public void setCow(List<String> cow) {
        this.cow = cow;
    }
}
