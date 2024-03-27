package com.solvd.api.graphql;

import com.solvd.api.api.BaseRestAssuredMethod;
import com.solvd.api.utils.Constants;

public class GraphQLRequest extends BaseRestAssuredMethod {
    public GraphQLRequest() {
        endpointUrl = Constants.GOREST_GRAPHQL_LINK;
    }
}
