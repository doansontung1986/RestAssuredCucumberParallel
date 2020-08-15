package environment;

import org.aeonbits.owner.ConfigFactory;
import utilities.ConfigFileReader;

public class EnvironmentConfig {
    private static Environment ENV = ConfigFactory.create(Environment.class);

    public static synchronized String getAppUrl() {
        String environment = System.getProperty("env");
        String testUrl = "";

        if (null != environment) {
            ConfigFactory.setProperty("env", environment);
            testUrl = ENV.getUrl();
        } else {
            testUrl = ConfigFileReader.getConfigFileReader().getUrl();
        }

        return testUrl;
    }
}
