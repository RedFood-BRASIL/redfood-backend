package com.github.vicenthy.endpoints.restaurante;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.github.vicenthy.endpoints.dto.BaseResponse;
import com.github.vicenthy.entity.restaurante.Categoria;

import org.bson.types.ObjectId;
@Path("/categoria")
@Produces("application/json")
@Consumes("application/json")
@RolesAllowed("restaurante")
public class CategoriaEndPoint {
    
    @POST
    public Response create(Categoria categoria){
        categoria.persist();
        var base = new BaseResponse<Categoria>(categoria);
        return Response.ok(base).build();
    }

    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") String id){
        Categoria categoria = Categoria.findById(new ObjectId(id));
        var base = new BaseResponse<Categoria>(categoria);
        return Response.ok(base).build();
    }

    @GET
    public Response getByAll(){
        List<Categoria> categorias = Categoria.listAll();
        var base = new BaseResponse<List<Categoria>>(categorias);
        return Response.ok(base).build();
    }


    @PUT
    public Response update(Categoria categoria){
        categoria.update();
        var base = new BaseResponse<Categoria>(categoria);
        return Response.ok(base).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") String id){
        Categoria.deleteById(new ObjectId(id));
        var base = new BaseResponse<String>("Sucesso");
        return Response.ok(base).build();
    }

}
