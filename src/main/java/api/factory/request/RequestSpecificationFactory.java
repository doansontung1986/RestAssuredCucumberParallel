package api.factory.request;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationFactory {

    private RequestSpecBuilder requestSpec;
    private RequestSpecification requestSpecification;

    private RequestSpecBuilder getRequestSpec() {
        if (requestSpec == null) {
            requestSpec = new RequestSpecBuilder();
        }
        return requestSpec;
    }

    public RequestSpecification getGenericRequestSpec() {
        getRequestSpec();
        requestSpec.setContentType(ContentType.JSON);
        requestSpecification = requestSpec.build();
        return requestSpecification;
    }

    public RequestSpecification getAuthorizedRequestSpec(String accessToken) {
        getRequestSpec();
        requestSpec.setContentType(ContentType.JSON);
        try {
            if (accessToken != null) {
                requestSpec.addHeader(RequestHeaderConfig.RequestHeaderKey.AUTHORIZATION,
                        RequestHeaderConfig.RequestHeaderValue.BEARER + accessToken);
            }
        } catch (Exception e) {
            System.out.println("User is not authenticated yet");
            e.printStackTrace();
        }
        requestSpecification = requestSpec.build();
        return requestSpecification;
    }
}
