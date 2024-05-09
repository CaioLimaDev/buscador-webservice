package com.br.buscador.produto.services;

import com.br.buscador.produto.entity.ProdutoDTO;
import com.br.buscador.produto.entity.ProdutoFilter;
import com.br.buscador.util.pagination.Paginado;
import io.vertx.ext.web.FileUpload;
import jakarta.ws.rs.core.Response;

import java.io.IOException;
import java.util.List;

public interface ProdutoService {

    Paginado<ProdutoDTO> buscarProdutosFiltrados(ProdutoFilter produtoFilter);


}
