package com.solvd.api.api.comments;

import com.solvd.api.api.BaseRestAssuredMethod;
import com.solvd.api.utils.Constants;

public class PostCommentMethod extends BaseRestAssuredMethod {
    public static final String POST_JSON_SCHEMA_PATH = "comments/_post/rs.json";

    public PostCommentMethod() {
        endpointUrl = Constants.GOREST_LINK + "/comments";
    }
}
