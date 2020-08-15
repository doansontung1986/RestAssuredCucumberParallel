package api.factory.request;

import api.factory.restassured.RestAssuredClient;
import api.factory.restassured.Route;
import environment.EnvironmentConfig;
import io.restassured.filter.Filter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestClient {
    private int port = 8085;
    private RequestSpecification request;
    private Filter filterLog;

    public RequestClient() {
        setBaseURI();
        setPort();
        setBasePath();
        getRequestSpecification();
        setFilter();
    }

    private void setBaseURI() {
        RestAssuredClient.getInstance().setURI(EnvironmentConfig.getAppUrl());
    }

    private void setPort() {
        RestAssuredClient.getInstance().setPort(port);
    }

    private void setBasePath() {
        RestAssuredClient.getInstance().setBasePath(Route.getBasePath());
    }

    private RequestSpecification getRequestSpecification() {
        request = RestAssuredClient.getInstance().getRequestSpecification();
        return request;
    }

    private RequestSpecification setFilter() {
        request = RestAssuredClient.getInstance().setFilter();
        return request;
    }

    public Filter getFilterLog() {
        filterLog = RestAssuredClient.getInstance().getLogFilter();
        return filterLog;
    }

    public Response getRequest(RequestSpecification requestSpecification, String path) {
        return request.spec(requestSpecification)
                .when()
                .get(path);
    }

    public Response postRequest(RequestSpecification requestSpecification, Object object, String path) {
        return request.spec(requestSpecification)
                .body(object)
                .when()
                .post(path);
    }

    public Response putRequest(RequestSpecification requestSpecification, Object object, String path) {
        return request.spec(requestSpecification)
                .body(object)
                .when()
                .put(path);
    }
}
