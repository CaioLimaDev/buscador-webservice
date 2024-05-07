package com.br.buscador.mercado.entity;

import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface MercadoMapper {

    MercadoDTO paraDTO(Mercado mercado);
    Mercado paraEntidade(MercadoDTO mercadoDTO);
}
