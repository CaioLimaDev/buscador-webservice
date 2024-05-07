package com.br.buscador.mercado.entity;

import com.br.buscador.produto.entity.ProdutoDTO;

import java.util.List;

public class MercadoDTO {

    private Integer id;
    private String nome;
    private String logo;
    private List<ProdutoDTO> produtos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<ProdutoDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoDTO> produtos) {
        this.produtos = produtos;
    }
}
