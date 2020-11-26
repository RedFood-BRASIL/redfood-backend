package com.github.vicenthy.entity.restaurante;

import java.time.Instant;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class HorarioDeFuncionamento extends PanacheMongoEntity{

    public HorarioDeFuncionamento(){}
    public String diaDaSemana;
    public Boolean aberto;
    public Instant horaDe;
    public Instant horaAte;
}
