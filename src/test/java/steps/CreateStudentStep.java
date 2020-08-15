package steps;

import context.Context;
import context.TestContext;
import cucumber.api.java.en.When;
import endpoints.CreateStudentEndpoint;
import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CreateStudentStep {
    private TestContext testContext;
    private Response response;
    private CreateStudentEndpoint createStudentEndpoint;

    public CreateStudentStep(TestContext testContext) {
        this.testContext = testContext;
        createStudentEndpoint = new CreateStudentEndpoint(testContext);
    }

    @When("I call API to create new student as below info")
    public void createNewStudentWithInfo(DataTable studentDataTable) {
        List<Map<String, String>> studentDataList = studentDataTable.asMaps(String.class, String.class);

        for (Map<String, String> studentData : studentDataList) {
            String firstName = studentData.get("First Name");
            String lastName = studentData.get("Last Name");
            String email = studentData.get("Email");
            String programme = studentData.get("Programme");
            List<String> courses = Arrays.asList(studentData.get("Courses").split(","));

            response = createStudentEndpoint.createStudent(firstName, lastName, email, programme, courses);
        }

        testContext.getScenarioContext().setContext(Context.RESPONSE, response);
    }
}