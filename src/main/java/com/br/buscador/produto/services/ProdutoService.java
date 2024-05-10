package com.br.buscador.produto.services;

import com.br.buscador.produto.entity.ProdutoDTO;
import com.br.buscador.produto.entity.ProdutoFilter;
import com.br.buscador.util.pagination.Paginado;

public interface ProdutoService {

    Paginado<ProdutoDTO> buscarProdutosFiltrados(ProdutoFilter produtoFilter);


}
