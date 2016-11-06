package vn.edu.uit.quanlybo.Respone;

/**
 * Created by phuc9 on 10/30/2016.
 */

public class APIError {

    private int statusCode;
    private String message;

    public APIError() {
    }

    public int status() {
        return statusCode;
    }

    public String message() {
        return message;
    }
}
