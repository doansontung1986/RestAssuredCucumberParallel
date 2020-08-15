package steps;

import context.Context;
import context.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
    private TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        this.testContext.getScenarioContext().setContext(Context.SCENARIO, scenario);

    }

    @After
    public void afterScenario() {
        System.out.println("End of scenario");
    }
}
