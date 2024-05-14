package com.br.buscador.mercado.entity;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface MercadoMapper {

    @Mapping(target = "produtos", ignore = true)
    Mercado paraEntidade(MercadoDTO mercadoDTO);

    List<Mercado> paraListaDeEntidades(List<MercadoDTO> mercadoDTOS);

    MercadoDTO paraDTO(Mercado mercado);

    List<MercadoDTO> paraListaDeDTOs(List<Mercado> mercados);
}
