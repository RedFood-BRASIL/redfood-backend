package com.github.vicenthy.endpoints.dto;

public class TokenDTO {

    private Long expiresIn;
    private String accessToken;
    private String refreshToken;
    private String typeExpires;

    public TokenDTO() {
        this.typeExpires = "seconds";

    }


    public TokenDTO(Long expiresIn, String accessToken, String refreshToken, String typeExpires) {
        this.expiresIn = expiresIn;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.setTypeExpires(typeExpires);
    }




    public String getTypeExpires() {
        return typeExpires;
    }

    public void setTypeExpires(String typeExpires) {
        this.typeExpires = typeExpires;
    }
    
    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }


}