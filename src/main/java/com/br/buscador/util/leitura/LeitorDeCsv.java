package com.br.buscador.util.leitura;

import com.br.buscador.mercado.entity.Mercado;
import com.br.buscador.mercado.entity.MercadoDTO;
import com.br.buscador.produto.entity.Produto;
import com.br.buscador.produto.entity.ProdutoDTO;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeitorDeCsv {

    public Map<MercadoDTO, List<ProdutoDTO>> lerCsv(CSVParser csvParser) {
        Map<MercadoDTO, List<ProdutoDTO>> mercadoProdutoMap = new HashMap<>();
        for (CSVRecord record : csvParser) {
            ProdutoDTO produtoDTO = new ProdutoDTO();
            produtoDTO.setNomeProduto(record.get("nome"));
            produtoDTO.setPrecoProduto(Double.parseDouble(record.get("preco")));
            produtoDTO.setUnidadeMedida(record.get("unidadeMedida"));
            produtoDTO.setImagem(record.get("imagemProduto"));

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

    public List<Mercado> criarMercados(Map<MercadoDTO, List<ProdutoDTO>> mercadoProdutoMap) {
        List<Mercado> mercados = new ArrayList<>();
        for (Map.Entry<MercadoDTO, List<ProdutoDTO>> entry : mercadoProdutoMap.entrySet()) {
            Mercado mercado = new Mercado();
            MercadoDTO mercadoDTO = entry.getKey();
            mercado.setNome(mercadoDTO.getNome());
            mercado.setLogo(mercadoDTO.getLogo());

            List<ProdutoDTO> produtoDTOList = entry.getValue();
            List<Produto> produtos = new ArrayList<>();

            for (ProdutoDTO produtoDTO : produtoDTOList) {
                Produto produto = new Produto();
                produto.setNomeProduto(produtoDTO.getNomeProduto());
                produto.setPrecoProduto(produtoDTO.getPrecoProduto());
                produto.setImagem(produtoDTO.getImagem());
                produto.setCategoria(produtoDTO.getCategoria());
                produto.setMercado(mercado);
                produtos.add(produto);
            }
            mercado.setProdutos(produtos);
            mercados.add(mercado);
        }
        return mercados;
    }
}
