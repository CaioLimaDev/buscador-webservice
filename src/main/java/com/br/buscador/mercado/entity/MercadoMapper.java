package com.br.buscador.mercado.entity;

import com.br.buscador.categorias.entity.CategoriaMapper;
import com.br.buscador.produto.entity.ProdutoMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface MercadoMapper {

    Mercado paraEntidade(MercadoDTO mercadoDTO);

    List<Mercado> paraListaDeEntidades(List<MercadoDTO> mercadoDTOS);

    MercadoDTO paraDTO(Mercado mercado);
}
