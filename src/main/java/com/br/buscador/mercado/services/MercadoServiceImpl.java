package com.br.buscador.mercado.services;

import com.br.buscador.mercado.entity.Mercado;
import com.br.buscador.mercado.entity.MercadoDTO;
import com.br.buscador.mercado.entity.MercadoMapper;
import com.br.buscador.mercado.repository.MercadoRepository;
import com.br.buscador.produto.entity.ProdutoDTO;
import com.br.buscador.util.leitura.LeitorDeCsv;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class MercadoServiceImpl implements MercadoService{

    @Inject
    MercadoRepository mercadoRepository;
    @Inject
    MercadoMapper mercadoMapper;

    @Override
    @Transactional
    public Response salvarMercadosEProdutos(FileUpload fileUpload) throws IOException {
        try {
            InputStream inputStream = new FileInputStream(fileUpload.uploadedFile().toString());

            Reader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withDelimiter(';'));
            LeitorDeCsv leitorDeCsv = new LeitorDeCsv();
            Map<MercadoDTO, List<ProdutoDTO>> mercadoProdutoMap = leitorDeCsv.lerCsv(csvParser);
            Mercado mercado = leitorDeCsv.criarMercados(mercadoProdutoMap);
            mercadoRepository.persist(mercado);

            return Response.ok().build();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Response buscarMercados() {
        return Response.ok(mercadoRepository.listAll()).build();
    }
}
