package com.br.buscador.mercado.repository;

import com.br.buscador.mercado.entity.Mercado;
import com.br.buscador.mercado.entity.MercadoDTO;
import com.br.buscador.util.pagination.Paginado;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Page;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;


@ApplicationScoped
public class MercadoRepository implements PanacheRepositoryBase<Mercado, Integer> {

    public void validarESalvarMercado(Mercado mercado) {
        Mercado mercadoExistente = Mercado.find("nome", mercado.getNome()).firstResult();

        if (mercadoExistente != null) {

            mercadoExistente.setNome(mercado.getNome());
            mercadoExistente.setLogo(mercado.getLogo());

            mercadoExistente.persist();
        } else {
            mercado.persist();
        }
    }

    public Paginado<Mercado> buscarMercadosPaginado(){
        Page page = new Page(0,20);
        PanacheQuery<Mercado> mercados = findAll();

        Paginado<Mercado> resultado = new Paginado<>();
        resultado.result = mercados.page(page).list();
        resultado.pageTotal = mercados.pageCount();
        resultado.page = page.index;
        resultado.pageSize = page.size;

        return resultado;
    }

}
