package com.br.buscador.mercado.services;

import com.br.buscador.categorias.entity.CategoriaMapper;
import com.br.buscador.mercado.entity.Mercado;
import com.br.buscador.mercado.entity.MercadoDTO;
import com.br.buscador.mercado.entity.MercadoMapper;
import com.br.buscador.mercado.repository.MercadoRepository;
import com.br.buscador.produto.entity.ProdutoDTO;
import com.br.buscador.util.leitura.LeitorDeCsv;
import io.vertx.ext.web.FileUpload;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class MercadoServiceImpl implements MercadoService{

    @Inject
    MercadoRepository mercadoRepository;
    @Inject
    CategoriaMapper categoriaMapper;

    @Override
    public Response salvarMercadosEProdutos(FileUpload fileUpload) throws IOException {
        try {
            InputStream inputStream = new FileInputStream(fileUpload.toString());

            Reader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            LeitorDeCsv leitorDeCsv = new LeitorDeCsv();
            Map<MercadoDTO, List<ProdutoDTO>> mercadoProdutoMap = leitorDeCsv.lerCsv(csvParser);
            List<Mercado> mercados = leitorDeCsv.criarMercados(mercadoProdutoMap,categoriaMapper);

            for (Mercado mercado : mercados){
                mercadoRepository.persist(mercado);
            }
            return Response.ok().build();
        } catch (Exception e) {
            throw e;
        }
    }
}
