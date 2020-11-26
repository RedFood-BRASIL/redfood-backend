package com.github.vicenthy.entity.restaurante;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class Endereco extends PanacheMongoEntity {


    public Endereco(){}
    public String cep;
    public String logradouro;
    public String numero;
    public String bairro;
    public String municipio;
    public String estado;
    public Double latitude;
    public Double longitude;

}
