package api.factory.request;

public class RequestHeaderConfig {
    public class RequestHeaderKey {
        public static final String CONTENT_TYPE = "Content-Type";
        public static final String AUTHORIZATION = "Authorization";
    }

    public class RequestHeaderValue {
        public static final String CONTENT_TYPE_JSON = "application/json;charset=UTF-8";
        public static final String BEARER = "Bearer ";
        public static final String CONTENT_TYPE_MULTIPART_FORM_DATA = "multipart/form-data";
    }


}
