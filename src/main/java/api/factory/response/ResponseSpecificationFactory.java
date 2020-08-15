package api.factory.response;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThan;

public class ResponseSpecificationFactory {
    private ResponseSpecBuilder responseSpec;
    private ResponseSpecification responseSpecification;

    private ResponseSpecBuilder getResponseSpec() {
        if (responseSpec == null) {
            responseSpec = new ResponseSpecBuilder();
        }
        return responseSpec;
    }

    public ResponseSpecification getGenericResponseSpec() {
        getResponseSpec();
        responseSpec.expectHeader(ResponseHeaderConfig.ResponseHeaderKey.CONTENT_TYPE,
                ResponseHeaderConfig.ResponseHeaderValue.CONTENT_TYPE_JSON);
        responseSpec.expectHeader(ResponseHeaderConfig.ResponseHeaderKey.ENCODING_TYPE,
                ResponseHeaderConfig.ResponseHeaderValue.END_CODING_CHUNKED);
        responseSpec.expectResponseTime(lessThan(ResponseHeaderConfig.ResponseHeaderValue.RESPONSE_TIME),
                TimeUnit.SECONDS);
        responseSpecification = responseSpec.build();
        return responseSpecification;
    }

}
