package com.github.vicenthy.config.mapper;

import com.github.vicenthy.endpoints.dto.EnderecoPostDTO;
import com.github.vicenthy.endpoints.dto.restaurante.RestauranteGetDTO;
import com.github.vicenthy.endpoints.dto.restaurante.RestaurantePostDTO;
import com.github.vicenthy.entity.restaurante.Endereco;
import com.github.vicenthy.entity.restaurante.Restaurante;

import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "cdi")
public interface RestauranteMapper {

    RestauranteMapper INSTANCE = Mappers.getMapper(RestauranteMapper.class);

    EnderecoPostDTO toEnderecoPostDTO(Endereco endereco);

    RestaurantePostDTO toRestaurantePostDTO(Restaurante restaurante);

    @Mapping(target = "id", expression = "java(restaurante.id.toString())")
    @Mapping(target = "password", ignore = true)
    RestauranteGetDTO toRestauranteGetDTO(Restaurante restaurante);

    Restaurante toRestaurante(RestaurantePostDTO restaurantePostDTO);

    default ObjectId toObjectId(String id){
        return new ObjectId(id);
    }

    default String toObjectId(ObjectId id){
        return id != null ? id.toString() : null;
    }
}
