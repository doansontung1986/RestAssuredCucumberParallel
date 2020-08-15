package environment;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:env.${env}.properties" // mention the property file name
})
public interface Environment extends Config {
    @Key("url")
    String getUrl();
}
