package api.factory.restassured;

import api.logConfigs.CustomLogFilter;
import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.specification.RequestSpecification;

public class RestAssuredClient {
    private static RestAssuredClient restAssuredClient;
    private RequestSpecification request;
    private Filter logFilter;

    private RestAssuredClient() {

    }

    public synchronized static RestAssuredClient getInstance() {
        if (restAssuredClient == null) {
            restAssuredClient = new RestAssuredClient();
        }
        return restAssuredClient;
    }

    public void setURI(String baseURI) {
        RestAssured.baseURI = baseURI;
    }

    public void setPort(int port) {
        RestAssured.port = port;
    }

    public void setBasePath(String basePath) {
        RestAssured.basePath = basePath;
    }

    public RequestSpecification getRequestSpecification() {
        request = RestAssured.given();
        return request;
    }

    public Filter getLogFilter() {
        if (logFilter == null) {
            logFilter = new CustomLogFilter();
        }
        return logFilter;
    }

    public RequestSpecification setFilter() {
        request.filter(getLogFilter());
        return request;
    }
}
