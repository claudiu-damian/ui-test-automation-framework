package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static utils.InitializationUtil.*;

public class BaseTest {
    @Before
    public void instantiateBrowser() {
        addDriverToMap();
    }

    @After("not @lol")
    public void tearDown() {
        closeDriver();
        clearMap();
    }

    @AfterStep
    public void takeScreenshot(Scenario scenario) {
        addScreenshotToReport(scenario);
    }
}
