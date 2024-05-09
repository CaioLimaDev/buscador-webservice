package com.br.buscador.produto.entity;

import com.br.buscador.categorias.entity.CategoriaMapper;
import com.br.buscador.mercado.entity.MercadoMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface ProdutoMapper {

    List<Produto> paraListaDeEntidades(List<ProdutoDTO> produtoDTO);
    Produto paraEntidade(ProdutoDTO produtoDTO);

    List<ProdutoDTO> paraListaDeDTO(List<Produto> produtos);

    default ProdutoDTO paraDTO(Produto produto, CategoriaMapper categoriaMapper, MercadoMapper mercadoMapper){

        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setId(produto.getId());
        produtoDTO.setNomeProduto(produto.getNomeProduto());
        produtoDTO.setPrecoProduto(produto.getPrecoProduto());
        produtoDTO.setImagem(produto.getImagem());

        if (produto.getCategoria() != null){
            produtoDTO.setCategoria(categoriaMapper.paraDTO(produto.getCategoria()));
        }
        if (produto.getMercado() != null){
            produtoDTO.setMercado(mercadoMapper.paraDTO(produto.getMercado()));
        }

        return produtoDTO;
    }

}
