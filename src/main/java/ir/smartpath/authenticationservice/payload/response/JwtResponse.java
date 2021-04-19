package ir.smartpath.authenticationservice.payload.response;

import java.util.List;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private boolean filledProfile;


    public JwtResponse(String accessToken, Long id, boolean filledProfile) {
        this.token = accessToken;
        this.id = id;
        this.filledProfile = filledProfile;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isFilledProfile() {
        return filledProfile;
    }

    public void setFilledProfile(boolean filledProfile) {
        this.filledProfile = filledProfile;
    }
}
