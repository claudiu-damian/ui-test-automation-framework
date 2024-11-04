package pages.airbnb_comp;

import component.BasePage;

public class MainPage extends BasePage {

    public void enterWebsite(String url) {
        driver.get(url);
    }
}
