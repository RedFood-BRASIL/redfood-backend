package com.github.vicenthy.config.jwt;

import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.management.relation.Role;

import com.github.vicenthy.endpoints.dto.TokenDTO;

import org.eclipse.microprofile.config.inject.ConfigProperty;


@ApplicationScoped
public class TokenService {
    
    @ConfigProperty(name = "redfood.quarkusjwt.jwt.accessTokenDuration") public Long accessTokenDuration;
    @ConfigProperty(name = "redfood.quarkusjwt.jwt.refreshTokenDuration") public Long refreshTokenDuration;
    @ConfigProperty(name = "mp.jwt.verify.issuer") public String issuer;


    public TokenDTO createToken(String username, Set<Role> roles) throws Exception {
        TokenDTO token = new TokenDTO();
        token.setAccessToken(createAccessToken(username, roles));
        token.setRefreshToken(createRefreshToken(username, roles));
        token.setExpiresIn(accessTokenDuration);
        return token;
    }


    private String createAccessToken(String username, Set<Role> roles) throws Exception {
        return TokenUtils.generateToken(username, roles, accessTokenDuration, issuer);
    }

    private String createRefreshToken(String username, Set<Role> roles) throws Exception {
        return TokenUtils.generateToken(username, roles, refreshTokenDuration, issuer);
    }




}