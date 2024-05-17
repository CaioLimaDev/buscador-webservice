package com.br.buscador.produto.rest;

import com.br.buscador.produto.entity.ProdutoDTO;
import com.br.buscador.produto.entity.ProdutoFilter;
import com.br.buscador.produto.services.ProdutoService;
import com.br.buscador.util.pagination.Paginado;
import jakarta.inject.Inject;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/produtos")
public class ProdutoRest {

    @Inject
    ProdutoService produtoService;

    @GET
    @Path("/")
    public Response filtrarProduto(@BeanParam ProdutoFilter produtoFilter){
        Paginado<ProdutoDTO> produtos = produtoService.buscarProdutosFiltrados(produtoFilter);
        if(produtos.result.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"mensagem\":\"Não foi possível encontrar o produto\"}")
                    .build();
        }
        return Response.ok(produtos).build();
    }

    @GET
    @Path("/categorias")
    public List<String> buscarCategoriasProdutos(){
        return produtoService.buscarCategoriasProdutos();
    }

    @GET
    @Path("/id/{id}")
    public Response buscarProdutoPorId(@PathParam("id") Integer id){
        return Response.ok(produtoService.buscarProdutoPorId(id)).build();
    }
}