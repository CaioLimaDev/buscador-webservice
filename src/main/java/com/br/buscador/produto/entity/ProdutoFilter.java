package com.br.buscador.produto.entity;

import com.br.buscador.util.pagination.PageQuery;
import jakarta.ws.rs.QueryParam;

public class ProdutoFilter extends PageQuery {

    @QueryParam("nomeProduto")
    private String nomeProduto;
    @QueryParam("mercado")
    private String mercado;
    @QueryParam("precoProduto")
    private Double precoProduto;
    @QueryParam("categoria")
    private String categoria;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getMercado() {
        return mercado;
    }

    public void setMercado(String mercado) {
        this.mercado = mercado;
    }

    public Double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(Double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
