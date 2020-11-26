package com.github.vicenthy.entity.restaurante;

import java.math.BigDecimal;
import java.time.Instant;

import com.github.vicenthy.entity.enuns.OndeAplicarDesconto;
import com.github.vicenthy.entity.enuns.TipoDesconto;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class CupomDeDesconto extends PanacheMongoEntity{


    public CupomDeDesconto(){}
    public String codigo;
    public Instant inicio;
    public Instant vencimento;
    public TipoDesconto tipoDesconto;
    public BigDecimal valor;
    public OndeAplicarDesconto ondeAplicarDesconto;

}
