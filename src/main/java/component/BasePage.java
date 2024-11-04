package component;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import static utils.InitializationUtil.getDriver;

public class BasePage extends HtmlElement {
    protected WebDriver driver;

    public BasePage() {
        this.driver = getDriver();
        HtmlElementLoader.populatePageObject(this, driver);
    }
}
