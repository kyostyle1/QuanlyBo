package vn.edu.uit.quanlybo.Model.Market;

/**
 * Created by Jackson Nghi on 12/18/2016.
 */

public class CodeOTP {
    private String market_id;
    private int otp;
    private String expired_time;

    public CodeOTP(String market_id, int otp, String expired_time) {
        this.market_id = market_id;
        this.otp = otp;
        this.expired_time = expired_time;
    }

    public String getMarket_id() {
        return market_id;
    }

    public void setMarket_id(String market_id) {
        this.market_id = market_id;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    public String getExpired_time() {
        return expired_time;
    }

    public void setExpired_time(String expired_time) {
        this.expired_time = expired_time;
    }
}
