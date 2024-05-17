package com.br.buscador.produto.services;


import com.br.buscador.mercado.entity.MercadoMapper;
import com.br.buscador.produto.entity.Produto;
import com.br.buscador.produto.entity.ProdutoDTO;
import com.br.buscador.produto.entity.ProdutoFilter;
import com.br.buscador.produto.entity.ProdutoMapper;
import com.br.buscador.produto.repository.ProdutoRepository;
import com.br.buscador.util.pagination.Paginado;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ProdutoServiceImpl implements ProdutoService{

    @Inject
    ProdutoRepository produtoRepository;
    @Inject
    ProdutoMapper produtoMapper;

    @Override
    public Paginado<ProdutoDTO> buscarProdutosFiltrados(ProdutoFilter produtoFilter) {
        Paginado<Produto> produtos = produtoRepository.filtrarProdutos(produtoFilter);
        return Paginado.from(produtos, produtos.result.stream()
                .map(produto -> produtoMapper.paraDTO(produto))
                .collect(Collectors.toList()));
    }

    @Override
    public List<String> buscarCategoriasProdutos() {
        return produtoRepository.buscarCategoriasExistentes();
    }

    @Override
    public ProdutoDTO buscarProdutoPorId(Integer id) {
        return produtoMapper.paraDTO(produtoRepository.findById(id));
    }
}
