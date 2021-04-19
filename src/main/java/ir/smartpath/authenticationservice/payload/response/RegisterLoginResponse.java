package ir.smartpath.authenticationservice.payload.response;

public class RegisterLoginResponse {

    public RegisterLoginResponse(Long userId, String msg, int resCOde) {
        this.userId = userId;
        this.msg = msg;
        this.resCOde = resCOde;
    }

    private Long userId;

    private String msg;

    private int resCOde;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getResCOde() {
        return resCOde;
    }

    public void setResCOde(int resCOde) {
        this.resCOde = resCOde;
    }
}
