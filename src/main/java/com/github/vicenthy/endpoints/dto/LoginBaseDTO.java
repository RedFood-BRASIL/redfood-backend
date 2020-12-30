package com.github.vicenthy.endpoints.dto;

import javax.validation.constraints.NotNull;

public class LoginBaseDTO {


   @NotNull
   public String login;
   @NotNull
   public String password;
   public String email; 
}