package com.solvd.api.api.posts;

import com.solvd.api.api.BaseRestAssuredMethod;
import com.solvd.api.utils.Constants;

public class GetPostsMethod extends BaseRestAssuredMethod {
    public static final String GET_JSON_SCHEMA_PATH = "posts/rs.json";

    public GetPostsMethod() {
        endpointUrl = Constants.GOREST_LINK + "/posts";
    }
}
