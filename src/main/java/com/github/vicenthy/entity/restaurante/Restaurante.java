package com.github.vicenthy.entity.restaurante;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class Restaurante extends PanacheMongoEntity {

    public Restaurante(){}
    public String logoUrl;
    public String nomeDaEmpresa;
    public String categoriaEmpresa;
    public Endereco endereco;
    public String email;
    public String telefone;

}
