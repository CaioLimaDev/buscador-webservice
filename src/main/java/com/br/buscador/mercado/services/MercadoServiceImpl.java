package com.br.buscador.mercado.services;

import com.br.buscador.mercado.entity.Mercado;
import com.br.buscador.mercado.entity.MercadoDTO;
import com.br.buscador.mercado.entity.MercadoMapper;
import com.br.buscador.mercado.repository.MercadoRepository;
import com.br.buscador.produto.entity.ProdutoDTO;
import com.br.buscador.produto.entity.ProdutoMapper;
import com.br.buscador.util.leitura.LeitorDeCsv;
import com.br.buscador.util.pagination.Paginado;
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
import java.util.stream.Collectors;

@ApplicationScoped
public class MercadoServiceImpl implements MercadoService{

    @Inject
    MercadoRepository mercadoRepository;
    @Inject
    ProdutoMapper produtoMapper;
    @Inject
    MercadoMapper mercadoMapper;

    @Override
    @Transactional
    public Response salvarMercadosEProdutos(FileUpload fileUpload) throws IOException {
        try{
            InputStream inputStream = new FileInputStream(fileUpload.uploadedFile().toString());

            Reader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withDelimiter(';'));

            LeitorDeCsv leitorDeCsv = new LeitorDeCsv();
            Map<MercadoDTO, List<ProdutoDTO>> mercadoProdutoMap = leitorDeCsv.lerCsv(csvParser);

            Mercado mercado = leitorDeCsv.criarMercados(mercadoProdutoMap,produtoMapper);

            mercadoRepository.validarESalvarMercado(mercado);

            inputStream.close();
            return Response.ok().build();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Paginado<MercadoDTO> buscarMercados() {
        Paginado<Mercado> mercados = mercadoRepository.buscarMercadosPaginado();
        return Paginado.from(mercados, mercados.result.stream()
                .map(mercado -> mercadoMapper.paraDTO(mercado))
                .collect(Collectors.toList()));
    }
}
