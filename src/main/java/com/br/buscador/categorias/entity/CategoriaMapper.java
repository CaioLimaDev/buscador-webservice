package com.br.buscador.categorias.entity;

import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface CategoriaMapper {

    CategoriasDTO paraDTO(Categorias categorias);
}
