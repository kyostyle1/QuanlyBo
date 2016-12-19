package vn.edu.uit.quanlybo.Model.Market;

/**
 * Created by Jackson Nghi on 12/19/2016.
 */

public class RequestCodeOTP {
    private String user_id;
    private int otp;

    public RequestCodeOTP(String user_id, int otp) {
        this.user_id = user_id;
        this.otp = otp;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }
}
