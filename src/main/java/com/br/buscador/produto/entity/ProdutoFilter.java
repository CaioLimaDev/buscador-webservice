package com.br.buscador.produto.entity;

import com.br.buscador.categorias.entity.CategoriasDTO;
import com.br.buscador.mercado.entity.MercadoDTO;
import com.br.buscador.util.pagination.PageQuery;
import jakarta.ws.rs.QueryParam;

public class ProdutoFilter extends PageQuery {

    @QueryParam("nomeProduto")
    private String nomeProduto;
    @QueryParam("mercado")
    private MercadoDTO mercado;
    @QueryParam("precoProduto")
    private Double precoProduto;
    @QueryParam("categoria")
    private CategoriasDTO categoria;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public MercadoDTO getMercado() {
        return mercado;
    }

    public void setMercado(MercadoDTO mercado) {
        this.mercado = mercado;
    }

    public Double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(Double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public CategoriasDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriasDTO categoria) {
        this.categoria = categoria;
    }
}
