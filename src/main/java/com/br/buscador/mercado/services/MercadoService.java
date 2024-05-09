package com.br.buscador.mercado.services;

import io.vertx.ext.web.FileUpload;
import jakarta.ws.rs.core.Response;

import java.io.IOException;
import java.util.List;

public interface MercadoService {
    Response salvarMercadosEProdutos(FileUpload fileUpload) throws IOException;
}
