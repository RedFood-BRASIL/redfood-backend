package com.github.vicenthy.endpoints.security;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.management.relation.Role;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.github.vicenthy.config.jwt.TokenService;
import com.github.vicenthy.endpoints.dto.BaseResponse;
import com.github.vicenthy.endpoints.dto.LoginBaseDTO;
import com.github.vicenthy.endpoints.dto.TokenDTO;
import com.github.vicenthy.entity.restaurante.Restaurante;
import com.github.vicenthy.repository.RestauranteRepository;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/restaurante/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Restaurante", description = "Autenticação do restaurante")
public class TokenRestaurante {

    Set<Role> profileRole = new HashSet<>();
    @Inject
    TokenService tokenService;
    @Inject
    RestauranteRepository restauranteRepository;

    @POST
    @Path("token")
    @APIResponse(responseCode = "200")
    @APIResponse(responseCode = "404", description = "Resource not found")
    @Operation(summary = "")
    public Response login(@Valid LoginBaseDTO login) throws Exception {
        profileRole.add(new Role("restaurante", List.of()));
        Restaurante restaurante = restauranteRepository.findByEmailAndPassword(login.email, login.password);
          if(restaurante != null){
            var token = tokenService.createToken(login.login, profileRole);
            var responseDTO = new BaseResponse<TokenDTO>(token, "Sucesso!");
            return Response.ok(responseDTO).build();    
          } else{
              return Response.status(Status.NOT_FOUND).build();
          }
    }
}
