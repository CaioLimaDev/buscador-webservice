package com.br.buscador.produto.entity;

import com.br.buscador.categorias.entity.Categorias;
import com.br.buscador.mercado.entity.Mercado;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "PRODUTOS", schema = "dbo")
public class Produto extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NOME_PRODUTO")
    private String nomeProduto;
    @ManyToOne
    @JoinColumn(name = "MERCADO", nullable = false)
    private Mercado mercado;
    @Column(name = "PRECO_PRODUTO")
    private Double precoProduto;
    @ManyToOne
    @JoinColumn(name = "CATEGORIA_PRODUTO")
    private Categorias categoria;
    @Column(name = "IMAGEM_PRODUTO")
    private String imagem;

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

    public Mercado getMercado() {
        return mercado;
    }

    public void setMercado(Mercado mercado) {
        this.mercado = mercado;
    }

    public Double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(Double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
