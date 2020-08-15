package steps;

import context.Context;
import context.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import endpoints.VerificationHelper;
import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;

public class VerificationSteps {
    private TestContext testContext;

    public VerificationSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Then("I see the status code is {int}")
    public void checkStatusCode(int statusCode) {
        Response response = (Response) testContext.getScenarioContext().getContext(Context.RESPONSE);
        VerificationHelper.responseCodeValidation(response, statusCode);
    }

    @Then("I see the response header contains {string}")
    public void checkExistKeyInResponseHeader(String key) {
        Response response = (Response) testContext.getScenarioContext().getContext(Context.RESPONSE);
        VerificationHelper.checkResponseHeaderHasKey(response, key);
    }

    @Then("I see the response header contains {string} is {string}")
    public void checkExistKeyValueInResponseHeader(String key, String value) {
        Response response = (Response) testContext.getScenarioContext().getContext(Context.RESPONSE);
        VerificationHelper.checkResponseHeaderHasValue(response, key, value);
    }

    @Then("I see the response body contains {string}")
    public void checkExistKeyInResponseBody(String key) {
        Response response = (Response) testContext.getScenarioContext().getContext(Context.RESPONSE);
        VerificationHelper.checkResponseBodyHasKey(response, key);
    }

    @Then("I see the response body contains {string} is {string}")
    public void checkExistKeyValueInResponseBody(String key, String value) {
        Response response = (Response) testContext.getScenarioContext().getContext(Context.RESPONSE);
        VerificationHelper.checkResponseBodyHasValue(response, key, value);
    }

    @Then("I see the response body contains {string} is list of {string}")
    public void checkExistListKeyValueInResponseBody(String key, String value) {

    }

    @Then("I see the response body contains {string} is list of")
    public void checkExistKeyListValueInResponseBody(String key, DataTable dataTable) {
        Response response = (Response) testContext.getScenarioContext().getContext(Context.RESPONSE);
        VerificationHelper.checkResponseBodyHasMapValue(response, key, dataTable);
    }

    @And("I see the photo info match the upload photo")
    public void iSeeThePhotoInfoMatchTheUploadPhoto() {
        Response response = (Response) testContext.getScenarioContext().getContext(Context.RESPONSE);
//        VerificationEndpoint.checkAvatarMatchUploadPhoto(response, photo);
    }
}
