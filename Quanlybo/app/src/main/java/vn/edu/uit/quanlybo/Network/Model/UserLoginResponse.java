package vn.edu.uit.quanlybo.Network.Model;

import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import vn.edu.uit.quanlybo.Model.User;

/**
 * Created by phuc9 on 11/14/2016.
 */

public class UserLoginResponse {

    @SerializedName("success")
    boolean success;

    @SerializedName("message")
    String message;
    @SerializedName("data")
    String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }





    public UserLoginResponse() {
    }



    public  UserLoginResponse(boolean success, String message, String data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}