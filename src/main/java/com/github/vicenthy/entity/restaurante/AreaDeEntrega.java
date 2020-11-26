package com.github.vicenthy.entity.restaurante;

import java.math.BigDecimal;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class AreaDeEntrega extends PanacheMongoEntity {
    public Double raio;
    public BigDecimal valorMinimo;
    public BigDecimal taxaDeEntrega;
    public Integer tempoDeEntregaDe;
    public Integer tempoDeEntregaAte;

    public AreaDeEntrega(){

    }
    
}
