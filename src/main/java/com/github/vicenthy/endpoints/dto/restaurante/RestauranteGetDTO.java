package com.github.vicenthy.endpoints.dto.restaurante;

import com.github.vicenthy.endpoints.dto.EnderecoPostDTO;

public class RestauranteGetDTO {
 
    
    private String id;
    private String logoUrl;
    private String nomeDaEmpresa;
    private String categoriaEmpresa;
    private EnderecoPostDTO endereco;
    private String email;
    private String password;
    private String telefone;


    

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogoUrl() {
        return this.logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getNomeDaEmpresa() {
        return this.nomeDaEmpresa;
    }

    public void setNomeDaEmpresa(String nomeDaEmpresa) {
        this.nomeDaEmpresa = nomeDaEmpresa;
    }

    public String getCategoriaEmpresa() {
        return this.categoriaEmpresa;
    }

    public void setCategoriaEmpresa(String categoriaEmpresa) {
        this.categoriaEmpresa = categoriaEmpresa;
    }

    public EnderecoPostDTO getEndereco() {
        return this.endereco;
    }

    public void setEndereco(EnderecoPostDTO endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


}
