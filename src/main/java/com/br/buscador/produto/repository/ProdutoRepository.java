package com.br.buscador.produto.repository;


import com.br.buscador.mercado.entity.MercadoMapper;
import com.br.buscador.produto.entity.Produto;
import com.br.buscador.produto.entity.ProdutoFilter;
import com.br.buscador.util.pagination.Paginado;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Page;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.mapstruct.factory.Mappers;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

@ApplicationScoped
public class ProdutoRepository implements PanacheRepositoryBase<Produto,Integer> {


    public Paginado<Produto> filtrarProdutos(ProdutoFilter produtoFilter){
        StringJoiner query = new StringJoiner(" ");
        query.add("FROM Produtos p WHERE");
        query.add("(:nomeProduto IS NULL OR p.nomeProduto = :nomeProduto)");
        query.add("AND (:mercado IS NULL OR p.mercado.nome LIKE '%:mercado%')");
        query.add("AND (:precoProduto IS NULL OR p.precoProduto = :precoProduto)");
        query.add("AND (:categoria IS NULL OR p.categoria.descricao = '%:categoria%')");

        Map<String,Object> parametros = new HashMap<>();
        parametros.put("nomeProduto", produtoFilter.getNomeProduto());
        parametros.put("mercado", produtoFilter.getMercado());
        parametros.put("precoProduto", produtoFilter.getPrecoProduto());
        parametros.put("categoria", produtoFilter.getCategoria());

        Page page = new Page(produtoFilter.page, produtoFilter.pageSize);
        PanacheQuery<Produto> produtos = find(query.toString(), parametros);

        Paginado<Produto> resultado = new Paginado<>();
        resultado.result = produtos.page(page).list();
        resultado.pageTotal = produtos.pageCount();
        resultado.page = page.index;
        resultado.pageSize = page.size;

        return resultado;
    }
}
