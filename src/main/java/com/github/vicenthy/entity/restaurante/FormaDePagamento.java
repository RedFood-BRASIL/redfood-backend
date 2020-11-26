package com.github.vicenthy.entity.restaurante;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class FormaDePagamento extends PanacheMongoEntity {

    public FormaDePagamento(){}
    public String restauranteId;
    public String nome;
}
