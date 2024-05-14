package com.br.buscador.util.leitura;

import com.br.buscador.mercado.entity.Mercado;
import com.br.buscador.mercado.entity.MercadoDTO;
import com.br.buscador.produto.entity.Produto;
import com.br.buscador.produto.entity.ProdutoDTO;
import com.br.buscador.produto.entity.ProdutoMapper;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.text.DecimalFormat;
import java.util.*;

public class LeitorDeCsv {

    public Map<MercadoDTO, List<ProdutoDTO>> lerCsv(CSVParser csvParser) {
        Map<MercadoDTO, List<ProdutoDTO>> mercadoProdutoMap = new HashMap<>();
        for (CSVRecord record : csvParser) {
            ProdutoDTO produtoDTO = new ProdutoDTO();
            produtoDTO.setNomeProduto(record.get("nome"));
            produtoDTO.setPrecoProduto(formatarPrecoProduto(record.get("preco")));
            produtoDTO.setUnidadeMedida(record.get("unidadeMedida"));
            produtoDTO.setImagem(record.get("imagemProduto"));
            produtoDTO.setCategoria(record.get("categoria"));

            MercadoDTO mercadoDTO = new MercadoDTO();
            mercadoDTO.setLogo(record.get("imagemMercado"));
            mercadoDTO.setNome(record.get("mercadoVinculado"));


            if (!mercadoProdutoMap.containsKey(mercadoDTO)) {
                mercadoProdutoMap.put(mercadoDTO, new ArrayList<>());
            }
            mercadoProdutoMap.get(mercadoDTO).add(produtoDTO);
        }
        return mercadoProdutoMap;
    }

    public Mercado criarMercados(Map<MercadoDTO, List<ProdutoDTO>> mercadoProdutoMap, ProdutoMapper produtoMapper) {

        Mercado mercado = new Mercado();

        List<Produto> produtos = new ArrayList<>();

        for (Map.Entry<MercadoDTO, List<ProdutoDTO>> entry : mercadoProdutoMap.entrySet()) {
            MercadoDTO mercadoDTO = entry.getKey();
            mercado.setNome(mercadoDTO.getNome());
            mercado.setLogo(mercadoDTO.getLogo());

            List<ProdutoDTO> produtoDTOList = entry.getValue();

            for (ProdutoDTO produtoDTO : produtoDTOList) {
                Produto produto = produtoMapper.paraEntidade(produtoDTO);
                produto.setMercado(mercado);
                produtos.add(produto);
            }
            mercado.setProdutos(produtos);
        }
        return mercado;
    }

    private Double formatarPrecoProduto(String record){

        if (record.length() <= 6) {
            return Double.parseDouble(record);
        } else {
            String[] partes = record.split("\\.");
            if (partes.length > 2) {
                String valor = String.join("", Arrays.copyOf(partes, partes.length - 1)) + "." + partes[partes.length - 1];
                return Double.parseDouble(valor);
            } else {
                return Double.parseDouble(record);
            }
        }

    }
}
