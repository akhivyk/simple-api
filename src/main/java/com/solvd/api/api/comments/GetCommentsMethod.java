package com.solvd.api.api.comments;

import com.solvd.api.api.BaseRestAssuredMethod;
import com.solvd.api.utils.Constants;

public class GetCommentsMethod extends BaseRestAssuredMethod {
    public static final String GET_JSON_SCHEMA_PATH = "comments/_get/rs.json";

    public GetCommentsMethod() {
        endpointUrl = Constants.GOREST_BASE_URL + "/comments";
    }
}
