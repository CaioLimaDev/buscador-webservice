package com.br.buscador.produto.repository;

import com.br.buscador.produto.entity.Produto;
import com.br.buscador.produto.entity.ProdutoFilter;
import com.br.buscador.util.pagination.Paginado;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

@ApplicationScoped
public class ProdutoRepository implements PanacheRepositoryBase<Produto,Integer> {

    public Paginado<Produto> filtrarProdutos(ProdutoFilter produtoFilter){
        StringJoiner query = new StringJoiner(" ");
        query.add("FROM Produtos p WHERE");
        query.add("(:nomeProduto IS NULL OR p.nomeProduto = :nomeProduto)");
        query.add("AND (:mercado IS NULL OR p.mercado.id = :mercado)");
        query.add("AND (:precoProduto IS NULL OR p.precoProduto = :precoProduto)");
        query.add("AND (:categoria IS NULL OR p.categoria.id = :categoria)");

        Map<String,Object> parametros = new HashMap<>();
        parametros.put("nomeProduto", produtoFilter.getNomeProduto());
        parametros.put("mercado", produtoFilter.getMercado());
        parametros.put("precoProduto", produtoFilter.getPrecoProduto());
        parametros.put("categoria", produtoFilter.getCategoria());

        PanacheQuery<Produto> produtos = find(query.toString(), parametros);


    }
}
