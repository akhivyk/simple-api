package com.solvd.api.api.users;

import com.solvd.api.api.BaseRestAssuredMethod;
import com.solvd.api.utils.Constants;

public class PostUserMethod extends BaseRestAssuredMethod {

    public static final String POST_JSON_SCHEMA_PATH = "users/_post/rs.json";

    public PostUserMethod() {
        endpointUrl = Constants.GOREST_LINK + "/users";
    }
}
