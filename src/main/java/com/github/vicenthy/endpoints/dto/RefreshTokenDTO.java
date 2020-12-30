package com.github.vicenthy.endpoints.dto;

import javax.validation.constraints.NotNull;

public class RefreshTokenDTO {
   
    @NotNull
    public TokenDTO token;
}
