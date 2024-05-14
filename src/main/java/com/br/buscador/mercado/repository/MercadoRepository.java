package com.br.buscador.mercado.repository;

import com.br.buscador.mercado.entity.Mercado;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;


@ApplicationScoped
public class MercadoRepository implements PanacheRepository<Mercado> {

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


}
