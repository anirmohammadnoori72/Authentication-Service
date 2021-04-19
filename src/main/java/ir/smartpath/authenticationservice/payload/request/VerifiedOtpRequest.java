package ir.smartpath.authenticationservice.payload.request;

public class VerifiedOtpRequest {

    private long userId;
    private int opt;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getOpt() {
        return opt;
    }

    public void setOpt(int opt) {
        this.opt = opt;
    }
}
