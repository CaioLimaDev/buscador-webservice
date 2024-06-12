package com.br.buscador.mercado.services;

import com.br.buscador.mercado.entity.Mercado;
import com.br.buscador.mercado.entity.MercadoDTO;
import com.br.buscador.util.pagination.Paginado;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import java.io.IOException;
import java.util.List;

public interface MercadoService {

    Response salvarMercadosEProdutos(FileUpload fileUpload) throws IOException;

    Paginado<MercadoDTO> buscarMercados();

    MercadoDTO buscarMercadoPorId(Integer id);

}
