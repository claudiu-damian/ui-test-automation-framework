package definitions.airbnb_definitions;

import io.cucumber.java.en.Given;
import pages.airbnb_comp.MainPage;


public class MainPageDefinition {
    private final MainPage mainPage = new MainPage();

    @Given("^I enter website (.*?)$")
    public void enterWebsite(String url) {
        mainPage.enterWebsite(url);
    }
}
