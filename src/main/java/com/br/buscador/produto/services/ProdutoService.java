package com.br.buscador.produto.services;

import com.br.buscador.produto.entity.ProdutoDTO;
import com.br.buscador.produto.entity.ProdutoFilter;
import com.br.buscador.util.pagination.Paginado;

import java.util.List;

public interface ProdutoService {

    Paginado<ProdutoDTO> buscarProdutosFiltrados(ProdutoFilter produtoFilter);

    List<String> buscarCategoriasProdutos();

    ProdutoDTO buscarProdutoPorId(Integer id);
}
