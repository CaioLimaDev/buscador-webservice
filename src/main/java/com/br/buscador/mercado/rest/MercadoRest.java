package com.br.buscador.mercado.rest;

import com.br.buscador.mercado.entity.MercadoDTO;
import com.br.buscador.mercado.services.MercadoService;
import com.br.buscador.util.pagination.Paginado;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;

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


    @GET
    @Path("/")
    public Response buscarMercados(){
        Paginado<MercadoDTO> mercados = mercadoService.buscarMercados();
        if (mercados.result.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"mensagem\":\"Não foi possível encontrar mercados\"}")
                    .build();
        }
        return Response.ok(mercados).build();
    }
}
