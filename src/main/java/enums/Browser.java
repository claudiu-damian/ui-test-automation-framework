package enums;

import lombok.AllArgsConstructor;

import static utils.PropertyUtils.getSystemProperty;

@AllArgsConstructor
public enum Browser {
    CHROME("chrome"),
    HEADLESS("headless"),
    FIREFOX("firefox");

    private final String browser;

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
