package com.br.buscador.mercado.repository;

import com.br.buscador.mercado.entity.Mercado;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class MercadoRepository implements PanacheRepository<Mercado> {
}
