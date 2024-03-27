package com.solvd.api.api.users;

import com.solvd.api.api.BaseRestAssuredMethod;
import com.solvd.api.utils.Constants;

public class UpdateUserMethod extends BaseRestAssuredMethod {
    public static final String UPDATE_JSON_SCHEMA_PATH = "users/_put/rs.json";

    public UpdateUserMethod(Integer userId) {
        endpointUrl = Constants.GOREST_BASE_URL + "/users/" + userId;
    }
}
