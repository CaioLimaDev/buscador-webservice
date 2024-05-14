package com.br.buscador.produto.entity;


import com.br.buscador.mercado.entity.MercadoDTO;

public class ProdutoDTO {

    private Integer id;
    private String nomeProduto;
    private MercadoDTO mercado;
    private Double precoProduto;
    private String unidadeMedida;
    private String categoria;
    private String imagem;

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
