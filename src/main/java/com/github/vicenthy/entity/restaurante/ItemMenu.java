package com.github.vicenthy.entity.restaurante;

import java.math.BigDecimal;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class ItemMenu extends PanacheMongoEntity {

    public ItemMenu(){}

    
    public String nomeDoItem;
    public Categoria categoria;
    public String descricaoItem;
    public BigDecimal valor;
    public BigDecimal valorPromocional;
}
