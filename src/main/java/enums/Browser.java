package enums;

import static utils.PropertyUtils.getSystemProperty;

public enum Browser {
    CHROME("chrome"),
    HEADLESS("headless"),
    FIREFOX("firefox");

    private final String browser;

    Browser(String browserType) {
        this.browser = browserType;
    }

    public String getDriverType() {
        String valueOfBrowserName = String.valueOf(getValueOfBrowserName(getSystemProperty("browser")));
        if (valueOfBrowserName.equals("HEADLESS"))
            return "CHROME";
        return valueOfBrowserName;
    }

    public static Browser getValueOfBrowserName(String browserName) {
        for (Browser browser : Browser.values())
            if (browser.browser.equalsIgnoreCase(browserName))
                return browser;
            return null;
    }
}
