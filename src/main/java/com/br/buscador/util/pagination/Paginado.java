package com.br.buscador.util.pagination;

import java.util.List;
import java.util.function.Function;

public class Paginado<T> {
    public int page;
    public int pageSize;
    public int pageTotal;
    public List<T> result;

    public <U> Paginado<U> map(Function<T, U> mapper){
        Paginado<U> convertedPaginado = new Paginado<>();
        convertedPaginado.page = this.page;
        convertedPaginado.pageSize = this.pageSize;
        convertedPaginado.pageTotal = this.pageTotal;
        convertedPaginado.result = this.result.stream().map(mapper).toList();
        return convertedPaginado;
    }
    public static <U> Paginado<U> from(Paginado<?> Paginado, List<U> result) {
        Paginado<U> convertedPaginado = new Paginado<>();
        convertedPaginado.page = Paginado.page;
        convertedPaginado.pageSize = Paginado.pageSize;
        convertedPaginado.pageTotal = Paginado.pageTotal;
        convertedPaginado.result = result;
        return convertedPaginado;
    }
}
