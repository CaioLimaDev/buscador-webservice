package com.br.buscador.util.leitura;

import com.br.buscador.categorias.entity.CategoriasDTO;
import com.br.buscador.mercado.entity.MercadoDTO;
import com.br.buscador.produto.entity.ProdutoDTO;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.util.ArrayList;
import java.util.List;

public class LeitorDeCsv {

    public List<ProdutoDTO>lerCsv(CSVParser csvParser){
        List<ProdutoDTO> listaProdutosDTO = new ArrayList<>();
        for (CSVRecord record : csvParser) {
            ProdutoDTO produtoDTO = new ProdutoDTO();
            produtoDTO.setNomeProduto(record.get("NomeProduto"));
            produtoDTO.setPrecoProduto(Double.parseDouble(record.get("PrecoProduto")));

            MercadoDTO mercadoDTO = new MercadoDTO();
            mercadoDTO.setLogo(record.get("LogoMercado"));
            mercadoDTO.setNome(record.get("Nome"));
            produtoDTO.setMercado(mercadoDTO);

            CategoriasDTO categoriasDTO = new CategoriasDTO();
            categoriasDTO.setDescricao(record.get("DescricaoCategoria"));
            produtoDTO.setCategoria(categoriasDTO);

            listaProdutosDTO.add(produtoDTO);
        }
        return listaProdutosDTO;
    }

}
