package com.github.vicenthy.endpoints.restaurante;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.github.vicenthy.config.mapper.RestauranteMapper;
import com.github.vicenthy.endpoints.dto.restaurante.RestauranteGetDTO;
import com.github.vicenthy.endpoints.dto.restaurante.RestaurantePostDTO;
import com.github.vicenthy.entity.restaurante.Restaurante;

import org.bson.types.ObjectId;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/restaurante")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "restaurantes", description = "Operations on restaurantes resource.")
public class RestauranteEndPoint {

    @Inject
    RestauranteMapper mapper;

    @GET
    @Operation(summary = "Get all restaurantes")
    public List<RestauranteGetDTO> get() {
        return Restaurante.listAll()
        .stream()
        .map( restaurante -> mapper.toRestauranteGetDTO((Restaurante) restaurante))
        .collect(Collectors.toList());
    }

    @GET
    @Path("{id}")
    @APIResponse(responseCode = "200")
    @APIResponse(responseCode = "404", description = "restaurante not found")
    @Operation(summary = "Find restaurante by ID")
    public Restaurante getSindle(@PathParam("id") String id) {
        return null;
    }

    @POST
    @Transactional
    @APIResponse(responseCode = "201",
            description = "restaurante created",
            content = @Content(schema = @Schema(implementation = Restaurante.class)))
    @APIResponse(responseCode = "406", description = "Invalid data")
    @APIResponse(responseCode = "409", description = "restaurante already exists")
    @Operation(summary = "Create new restaurante")
    public Response create(RestaurantePostDTO restaurantePostDTO) {
        Restaurante restaurante = mapper.toRestaurante(restaurantePostDTO);
        restaurante.persist();
        return Response.ok(restaurante).status(Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    @APIResponse(responseCode = "200",
            description = "restaurante created",
            content = @Content(schema = @Schema(implementation = Restaurante.class)))
    @APIResponse(responseCode = "404", description = "restaurante not found")
    @APIResponse(responseCode = "409", description = "restaurante already exists")
    @Operation(summary = "Edit restaurante by ID")
    public Response update(@PathParam("id") String id, @Valid Restaurante newRestaurante) {

        return Response.ok(null).status(Status.OK).build();
    }

    @DELETE
    @Transactional
    @Path("{id}")
    @APIResponse(responseCode = "204", description = "restaurante deleted")
    @APIResponse(responseCode = "404", description = "restaurante not found")
    @Operation(summary = "Delete restaurante by ID")
    public Response delete(@PathParam("id") String id) {
   

        return Response.status(Status.NO_CONTENT).build();
    }
}

