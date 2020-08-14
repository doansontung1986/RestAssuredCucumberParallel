package steps;

import io.cucumber.java.en.Given;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StepDefs extends BaseStep {

    @Test(description = "TC: LoginGoSELL", dataProvider = "scenarios")
    public void signUp(PickleWrapper pickle, FeatureWrapper cucumberFeature) {
        testRunner = new TestNGCucumberRunner(this.getClass());
        testRunner.runScenario(pickle.getPickle());
    }

    @Override
    public String getFeatureName() {
        return featureName;
    }

    @DataProvider
    public Object[][] scenarios() {
        return testRunner.provideScenarios();
    }

    @Given("a step from {string} in {string} feature file")
    public void step(String scenario, String file) throws InterruptedException {

        System.out.format("Thread ID – %2d – %s from %s feature file.\n",
                Thread.currentThread().getId(), scenario, file);
        Thread.sleep(3000);
    }
}