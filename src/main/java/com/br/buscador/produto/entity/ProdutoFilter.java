package com.br.buscador.produto.entity;

import com.br.buscador.util.pagination.PageQuery;
import jakarta.ws.rs.QueryParam;

import java.util.List;

public class ProdutoFilter extends PageQuery {

    @QueryParam("nomeProduto")
    private String nomeProduto;
    @QueryParam("mercado")
    private List<String> mercado;
    @QueryParam("precoProduto")
    private Double precoProduto;
    @QueryParam("categoria")
    private List<String> categoria;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public List<String> getMercado() {
        return mercado;
    }

    public void setMercado(List<String> mercado) {
        this.mercado = mercado;
    }

    public Double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(Double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public List<String> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<String> categoria) {
        this.categoria = categoria;
    }
}
