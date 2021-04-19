package ir.smartpath.authenticationservice.payload.request;

import javax.validation.constraints.NotBlank;

public class RegisterLoginRequest {
    @NotBlank
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
