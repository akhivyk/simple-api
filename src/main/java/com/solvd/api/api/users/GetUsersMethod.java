package com.solvd.api.api.users;

import com.solvd.api.api.BaseRestAssuredMethod;
import com.solvd.api.utils.Constants;

public class GetUsersMethod extends BaseRestAssuredMethod {
    public static final String GET_JSON_SCHEMA_PATH = "users/_get/rs.json";

    public GetUsersMethod() {
        endpointUrl = Constants.GOREST_LINK + "/users";
    }
}
