package com.br.buscador.mercado.entity;

import com.br.buscador.produto.entity.Produto;
import com.br.buscador.produto.entity.ProdutoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "cdi")
public interface MercadoMapper {

    @Mapping(target = "produtos.mercado", ignore = true)
    Mercado paraEntidade(MercadoDTO mercadoDTO);

    List<Mercado> paraListaDeEntidades(List<MercadoDTO> mercadoDTOS);

    default MercadoDTO paraDTO(Mercado mercado) {
        if ( mercado == null ) {
            return null;
        }

        MercadoDTO mercadoDTO = new MercadoDTO();

        mercadoDTO.setId( mercado.getId() );
        mercadoDTO.setNome( mercado.getNome() );
        mercadoDTO.setLogo( mercado.getLogo() );
        mercadoDTO.setProdutos( produtoListToProdutoDTOList( mercado.getProdutos() ) );

        return mercadoDTO;
    }

    List<MercadoDTO> paraListaDeDTOs(List<Mercado> mercados);

    @Mappings({
            @Mapping(target = "mercado", ignore = true)
    })
    ProdutoDTO produtoToProdutoDTO(Produto produto);

    default List<ProdutoDTO> produtoListToProdutoDTOList(List<Produto> produtos) {
        if (produtos == null) {
            return null;
        }
        return produtos.stream()
                .map(this::produtoToProdutoDTO)
                .collect(Collectors.toList());
    }
}
