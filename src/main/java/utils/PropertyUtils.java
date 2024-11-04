package utils;

import lombok.SneakyThrows;

import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {
    private static final String PROPS = "props/browser.properties";

    public static String getSystemProperty(String property) {
        return getProperty(PROPS, property);
    }

    @SneakyThrows
    public static String getProperty(String resource, String property) {
        InputStream resourcePath = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(resource);
        Properties props = new Properties();
        props.load(resourcePath);
        return props.getProperty(property);
    }
}
