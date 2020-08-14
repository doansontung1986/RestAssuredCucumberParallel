package steps;

import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class BaseStep {

    protected String featureName;
    protected TestNGCucumberRunner testRunner;

    public String getFeatureName() {
        return featureName;
    }

    @BeforeClass
    public void setUp() {
        testRunner = new TestNGCucumberRunner(this.getClass());
    }

    @BeforeMethod
    public void beforeMethod(Object[] params) {
        PickleWrapper pickleWrapper = (PickleWrapper) params[0];
        featureName = pickleWrapper.getPickle().getName();
    }

    @AfterClass
    public void tearDown() {
        testRunner.finish();
    }
}
