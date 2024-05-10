package com.br.buscador.mercado.services;

import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import java.io.IOException;

public interface MercadoService {
    Response salvarMercadosEProdutos(FileUpload fileUpload) throws IOException;
}
