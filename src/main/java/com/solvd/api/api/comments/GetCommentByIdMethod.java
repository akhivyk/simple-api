package com.solvd.api.api.comments;

import com.solvd.api.api.BaseRestAssuredMethod;
import com.solvd.api.utils.Constants;

public class GetCommentByIdMethod extends BaseRestAssuredMethod {
    public static final String GET_JSON_SCHEMA_PATH = "comments/_get/byId/rs.json";

    public GetCommentByIdMethod(Integer commentId) {
        endpointUrl = Constants.GOREST_BASE_URL + "/comments/" + commentId;
    }
}
