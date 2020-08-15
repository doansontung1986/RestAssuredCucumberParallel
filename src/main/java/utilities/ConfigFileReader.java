package utilities;

import java.io.*;
import java.util.Properties;

public class ConfigFileReader {
    private volatile static ConfigFileReader configFileReader;
    private Properties properties;
    private final String propertyFilePath = "src//test//resources//GlobalConfigurationProperties//Configuration.properties";

    private ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public synchronized static ConfigFileReader getConfigFileReader() {
        if (configFileReader == null) {
            configFileReader = new ConfigFileReader();
        }
        return configFileReader;
    }

    public String getUrl() {
        String url = properties.getProperty("URL");
        if (null != url) return url;
        else
            throw new RuntimeException("URL Key value in Configuration.properties is not matched : " + url);
    }

    public String getRootPath() {
        String rootPath = properties.getProperty("ROOT_PATH");
        if (null != rootPath) return System.getProperty(rootPath);
        else
            throw new RuntimeException("ROOT_PATH Key value in Configuration.properties is not matched : " + rootPath);
    }

    public String getUploadFilePath() {
        String uploadFilePath = properties.getProperty("UPLOAD_FILE_PATH");
        if (null != uploadFilePath) return getRootPath() + File.separator + uploadFilePath;
        else
            throw new RuntimeException("Upload File Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }
}
