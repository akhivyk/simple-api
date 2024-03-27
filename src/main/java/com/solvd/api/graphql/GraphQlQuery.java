package com.solvd.api.graphql;

import lombok.Data;

@Data
public class GraphQlQuery {

    private String query;

    private Object variables;

}
