package api.factory.response;

public class ResponseHeaderConfig {
    public class ResponseHeaderKey {
        public static final String CONTENT_TYPE = "Content-Type";
        public static final String ENCODING_TYPE = "Transfer-Encoding";
    }

    public class ResponseHeaderValue {
        public static final String CONTENT_TYPE_JSON = "application/json;charset=UTF-8";
        public static final String CONTENT_TYPE_MULTIPART_FORM_DATA = "multipart/form-data";
        public static final String END_CODING_CHUNKED = "chunked";
        public static final long RESPONSE_TIME = 5L;
    }
}
