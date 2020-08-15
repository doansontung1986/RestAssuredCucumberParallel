package endpoints;


import api.factory.request.RequestClient;
import api.factory.request.RequestSpecificationFactory;
import api.logConfigs.CustomLogFilter;
import context.Context;
import context.TestContext;
import cucumber.api.Scenario;
import io.restassured.filter.Filter;
import io.restassured.response.Response;
import model.student.request.ConcreteStudentPOJO;
import model.student.request.StudentRequest;
import utilities.DataGenerateHelper;

import java.util.List;

public class CreateStudentEndpoint extends Endpoint {
    private TestContext testContext;
    private RequestClient requestClient;
    private RequestSpecificationFactory requestSpecificationFactory;
    private Response response;
    private ConcreteStudentPOJO concreteStudentPOJO;
    private StudentRequest studentRequest;
    private DataGenerateHelper dataFake;
    private Scenario scenario;
    private Filter logFilter;

    public CreateStudentEndpoint(TestContext testContext) {
        this.testContext = testContext;
        requestClient = new RequestClient();
        concreteStudentPOJO = new ConcreteStudentPOJO();
        requestSpecificationFactory = new RequestSpecificationFactory();
        dataFake = DataGenerateHelper.getData();
    }

    public Response createStudent(String firstName, String lastName, String email,
                                  String programme, List<String> courses) {

        firstName = dataFake.getFirstName();
        lastName = dataFake.getLastName();
        email = dataFake.getEmail();

        StudentRequest studentRequest = new ConcreteStudentPOJO()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setProgramme(programme)
                .setCourses(courses)
                .build();

        response = requestClient.postRequest(requestSpecificationFactory.getGenericRequestSpec(),
                studentRequest, "");

        logFilter = requestClient.getFilterLog();

        scenario = (Scenario) testContext.getScenarioContext().getContext(Context.SCENARIO);

        if (logFilter instanceof CustomLogFilter) {
            CustomLogFilter customLogFilter = (CustomLogFilter) logFilter;
            scenario.write("\n" + customLogFilter.getRequestBuilder()
                    + "\n" + customLogFilter.getResponseBuilder());
        }

        return response;
    }
}
