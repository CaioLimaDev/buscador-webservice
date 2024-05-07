package com.br.buscador.categorias.entity;

import com.br.buscador.produto.entity.ProdutoDTO;

import java.util.List;

public class CategoriasDTO {

    private Integer id;
    private String descricao;
    private List<ProdutoDTO> produtos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<ProdutoDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoDTO> produtos) {
        this.produtos = produtos;
    }
}
