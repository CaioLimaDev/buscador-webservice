package com.br.buscador.mercado.repository;

import com.br.buscador.mercado.entity.Mercado;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MercadoRepository implements PanacheRepositoryBase<Mercado,Integer> {
}
