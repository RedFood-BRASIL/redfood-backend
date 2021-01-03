package com.github.vicenthy.repository;

import javax.enterprise.context.ApplicationScoped;

import com.github.vicenthy.entity.restaurante.Restaurante;

import io.quarkus.mongodb.panache.PanacheMongoRepository;


@ApplicationScoped
public class RestauranteRepository implements PanacheMongoRepository<Restaurante>{
    

    public Restaurante findByEmailAndPassword(String email, String password){
        return find("{ 'email': ?1, 'password': ?2 }", email, password).firstResult();
    }

    public Restaurante findByLoginAndPassword(String login, String password){
        return find("{ 'login': ?1, 'password': ?2 }", login, password).firstResult();
    }

}
