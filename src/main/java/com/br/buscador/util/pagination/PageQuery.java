package com.br.buscador.util.pagination;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.QueryParam;

public class PageQuery {
    @QueryParam("page")
    @DefaultValue("0")
    public Integer page = 0;

    @QueryParam("pageSize")
    @DefaultValue("20")
    public Integer pageSize = 20;
}
