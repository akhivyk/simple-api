package com.solvd.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.api.entity.Comment;
import com.solvd.api.entity.User;
import com.solvd.api.enums.HttpMethodTypeEnum;
import com.solvd.api.graphql.GraphQLRequest;
import com.solvd.api.graphql.GraphQlQuery;
import com.solvd.api.utils.FileReader;
import com.solvd.api.utils.RestAssuredUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GraphQLTest {

    private static final GraphQLRequest GRAPH_QL_REQUEST = new GraphQLRequest();
    private static final GraphQlQuery GRAPH_QL_QUERY = new GraphQlQuery();
    private User user;

    @Test(priority = 1)
    public void getAllUsersTest() {
        String query = FileReader.getQueryFromFile("src/test/resources/graphql/getAllUsers.graphql");

        GRAPH_QL_QUERY.setQuery(query);
        Response response = GRAPH_QL_REQUEST.executeGraphQL(HttpMethodTypeEnum.POST, GRAPH_QL_QUERY);

        RestAssuredUtils.assertSchema(response, "graphql/assertion/graphql_rs_all_users.json");
    }

    @Test(priority = 2)
    public void createUserTest() {
        String query = FileReader.getQueryFromFile("src/test/resources/graphql/createUser.graphql");

        User generatedUser = User.generateUser();
        GRAPH_QL_QUERY.setQuery(query);
        GRAPH_QL_QUERY.setVariables(generatedUser);

        Response response = GRAPH_QL_REQUEST.executeGraphQL(HttpMethodTypeEnum.POST, GRAPH_QL_QUERY);
        user = JsonPath.from(response.asString()).getObject("data.createUser.user", User.class);

        RestAssuredUtils.assertSchema(response, "graphql/assertion/graphql_rs_user_create.json");
    }

    @Test(priority = 3)
    public void getByIdUserTest() {
        String query = FileReader.getQueryFromFile("src/test/resources/graphql/getUserById.graphql");

        GRAPH_QL_QUERY.setQuery(query);
        GRAPH_QL_QUERY.setVariables(user);

        Response response = GRAPH_QL_REQUEST.executeGraphQL(HttpMethodTypeEnum.POST, GRAPH_QL_QUERY);
        User retrievedUser = JsonPath.from(response.asString()).getObject("data.user", User.class);

        Assert.assertEquals(retrievedUser.getId(), user.getId(), "Retrieved user id isn't equals to expected!");
    }

    @Test(priority = 4)
    public void updateUserTest() {
        String query = FileReader.getQueryFromFile("src/test/resources/graphql/updateUser.graphql");

        User updatedUser = User.builder()
                .id(user.getId())
                .name("Updated Name" + RandomStringUtils.randomAlphabetic(3))
                .build();

        GRAPH_QL_QUERY.setQuery(query);
        GRAPH_QL_QUERY.setVariables(updatedUser);

        Response response = GRAPH_QL_REQUEST.executeGraphQL(HttpMethodTypeEnum.POST, GRAPH_QL_QUERY);
        User retrievedUser = JsonPath.from(response.asString()).getObject("data.updateUser.user", User.class);

        Assert.assertEquals(retrievedUser.getId(), user.getId(), "Updated user id isn't equals to expected!");
        Assert.assertEquals(updatedUser.getName(), retrievedUser.getName(), "Name after updating isn't equals to expected!");
    }

    @Test(priority = 5)
    public void deleteUserTest() {
        String query = FileReader.getQueryFromFile("src/test/resources/graphql/deleteUser.graphql");

        GRAPH_QL_QUERY.setQuery(query);
        GRAPH_QL_QUERY.setVariables(user);

        Response response = GRAPH_QL_REQUEST.executeGraphQL(HttpMethodTypeEnum.POST, GRAPH_QL_QUERY);
        User deletedUser = JsonPath.from(response.asString()).getObject("data.deleteUser.user", User.class);

        Assert.assertEquals(deletedUser.getId(), deletedUser.getId(), "Id of deleted user isn't equals to expected!");
    }
}
