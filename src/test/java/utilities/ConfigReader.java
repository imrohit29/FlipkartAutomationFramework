package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConfigReader {
    private static Properties properties;
    private static final Logger logger = LogManager.getLogger(ConfigReader.class);

    static {
        try {
            String path = "src/test/resources/config.properties";
            FileInputStream fis = new FileInputStream(path);
            properties = new Properties();
            properties.load(fis);
            logger.info("Configuration properties loaded successfully");
        } catch (IOException e) {
            logger.error("Failed to load configuration properties", e);
            throw new RuntimeException("Configuration properties file not found.");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
