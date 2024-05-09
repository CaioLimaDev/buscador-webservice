package com.br.buscador.mercado.rest;

import com.br.buscador.mercado.services.MercadoService;
import io.vertx.ext.web.FileUpload;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestForm;

import java.io.FileInputStream;
import java.util.List;

@Path("/mercados")
public class MercadoRest {

    @Inject
    MercadoService mercadoService;

    @POST
    @Path("/")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response inserirProdutos(@RestForm("fileUpload") List<FileUpload> fileUploads) {

        fileUploads.forEach(fileUpload -> {
            try {
                mercadoService.salvarMercadosEProdutos(fileUpload);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        });

        return Response.ok().build();
    }
}
