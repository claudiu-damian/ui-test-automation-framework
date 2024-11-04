package utils;

import core.DriverFactory;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

import static enums.context_keys.ConfigKeys.DRIVER;
import static java.lang.Thread.currentThread;

@Log4j2
public class InitializationUtil {
    public static void addDriverToMap() {
        ExecutionContext.put(DRIVER, DriverFactory.getInstance());
        log.info("Driver added to map");
    }

    public static WebDriver getDriver() {
        return (WebDriver) ExecutionContext.get(DRIVER);
    }

    public static void closeDriver() {
        DriverFactory.quitDriver();
    }

    public static void clearMap() {
        ExecutionContext.removeFromGeneralMap(currentThread().getId());
        log.info(String.format("Execution map cleared for thread: [%s]", currentThread().getId()));
    }

    public static void addScreenshotToReport(Scenario scenario) {
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(
                ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES)
        ));
        log.info("Screenshot took and added to the report for scenario: " + scenario.getName());
    }
}
