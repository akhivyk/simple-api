package com.solvd.api.api.comments;

import com.solvd.api.api.BaseRestAssuredMethod;
import com.solvd.api.utils.Constants;

public class DeleteCommentMethod extends BaseRestAssuredMethod {

    public DeleteCommentMethod(Integer commentId) {
        endpointUrl = Constants.GOREST_LINK + "/comments/" + commentId;
    }
}
