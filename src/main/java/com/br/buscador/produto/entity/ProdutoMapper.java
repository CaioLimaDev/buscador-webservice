package com.br.buscador.produto.entity;

import com.br.buscador.mercado.entity.MercadoMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi", uses = MercadoMapper.class)
public interface ProdutoMapper {

    List<Produto> paraListaDeEntidades(List<ProdutoDTO> produtoDTO);

    Produto paraEntidade(ProdutoDTO produtoDTO);

    List<ProdutoDTO> paraListaDeDTO(List<Produto> produtos);

    ProdutoDTO paraDTO(Produto produto);

}
