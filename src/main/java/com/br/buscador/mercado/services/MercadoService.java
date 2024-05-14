package com.br.buscador.mercado.services;

import com.br.buscador.mercado.entity.MercadoDTO;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import java.io.IOException;
import java.util.List;

public interface MercadoService {
    Response salvarMercadosEProdutos(FileUpload fileUpload) throws IOException;
    Response buscarMercados();
}
