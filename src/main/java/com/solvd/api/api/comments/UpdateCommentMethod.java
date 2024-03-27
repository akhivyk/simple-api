package com.solvd.api.api.comments;

import com.solvd.api.api.BaseRestAssuredMethod;
import com.solvd.api.utils.Constants;

public class UpdateCommentMethod extends BaseRestAssuredMethod {
    public static final String PUT_JSON_SCHEME_PATH = "comments/_put/rs.json";

    public UpdateCommentMethod(Integer commentId) {
        endpointUrl = Constants.GOREST_BASE_URL + "/comments/" + commentId;
    }
}
