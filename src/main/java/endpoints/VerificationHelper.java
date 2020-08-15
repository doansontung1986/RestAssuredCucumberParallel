package endpoints;

import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VerificationHelper {

    public static void responseCodeValidation(Response response, int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    public static void responseKeyValidation(Response response, String key, String value) {
        JSONArray array = new JSONArray(response.getBody().asString());
        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = array.getJSONObject(i);
            Assert.assertEquals(value, obj.get(key));
            System.out.println("Validated values are " + obj.get(key));
        }
    }

    public static void checkResponseBodyHasKey(Response response, String key) {
        JSONObject json = new JSONObject(response.getBody().asString());
        Assert.assertTrue(json.has(key));
        System.out.println("Successfully validated response body has key: " + key);
    }

    public static void checkResponseBodyHasValue(Response response, String key, String value) {
        JSONObject json = new JSONObject(response.getBody().asString());
        if (json.has(key) && json.get(key) != null) {
            Assert.assertEquals(value, json.get(key));
            System.out.println("Successfully validated value of " + key + " It is " + json.get(key));
        }
    }

    public static void checkResponseHeaderHasKey(Response response, String key) {
        boolean hasHeader = response.getHeaders().hasHeaderWithName(key);
        Assert.assertTrue(hasHeader);
        System.out.println("Successfully validated response header has key: " + key);
    }

    public static void checkResponseHeaderHasValue(Response response, String key, String value) {
        boolean hasHeader = response.getHeaders().hasHeaderWithName(key);
        String headerValue = response.getHeaders().getValue(key);
        if (hasHeader && headerValue != null) {
            Assert.assertEquals(value, headerValue);
            System.out.println("Successfully validated value of " + key + " It is " + headerValue);
        }
    }

    public static void checkResponseBodyHasListValue(Response response, String key, String value) {
        String[] valueArray = value.split(",");
        List<Object> valueList = new ArrayList<>();
        List<Object> listInResponse = response.jsonPath().getList(key);

        if (listInResponse != null) {
            for (int i = 0; i < valueArray.length; i++) {
                valueList.add(valueArray[i].trim());
            }

            for (Object expectedValue : valueList) {
                for (Object responseValue : listInResponse) {
                    if (expectedValue.equals(responseValue)) {
                        Assert.assertEquals(expectedValue, responseValue);
                        break;
                    }
                }
            }
        }
    }

    public static void checkResponseBodyHasMapValue(Response response, String key, DataTable dataTable) {
        List<Map<Object, Object>> expectedValue = dataTable.asMaps(String.class, String.class);
        List<Map<Object, Object>> responseData = response.jsonPath().getList(key);

        for (Map value : expectedValue) {
            for (Object map : value.values()) {
                for (Map responseObj : responseData) {
                    for (Object mapResponse : responseObj.values()) {
                        if (map.toString().equals(mapResponse.toString())) {
                            Assert.assertEquals(map.toString(), mapResponse.toString());
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void responseTimeValidation(Response response) {
        long time = response.time();
        System.out.println("API response time: " + time);
    }

    public static void checkAvatarMatchUploadPhoto(Response response, String photo) {
        JSONObject json = new JSONObject(response.getBody().asString());
        Assert.assertEquals(json.get("photo"), photo);
    }
}
