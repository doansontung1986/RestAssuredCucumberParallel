package endpoints;

import io.restassured.http.Headers;
import io.restassured.response.Response;

public abstract class Endpoint {
    protected Response response;
    protected Headers responseHeader;
}
