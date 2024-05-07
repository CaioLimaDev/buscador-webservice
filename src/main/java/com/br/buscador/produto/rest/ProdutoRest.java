package com.br.buscador.produto.rest;

import com.br.buscador.produto.services.ProdutoService;
import io.vertx.ext.web.FileUpload;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestForm;

import java.io.FileInputStream;
import java.util.List;

@Path("/produtos")
public class ProdutoRest {

    @Inject
    ProdutoService produtoService;

    @GET
    @Path("/")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response inserirProdutos(@RestForm("fileUpload") List<FileUpload> fileUploads) {

            fileUploads.forEach(fileUpload -> {
                String arquivo = fileUpload.toString();
                try {
                    FileInputStream streamFile = new FileInputStream(arquivo);
                    produtoService.salvarProdutos(fileUploads);
                }catch (Exception e){
                    throw new RuntimeException(e);
                }
            });

            return Response.ok().build();
    }
}