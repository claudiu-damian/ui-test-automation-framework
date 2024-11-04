package component.airbnb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(css = "[class*='atm_e2_11wdtgu']")
public class MapComponent extends HtmlElement {

    @FindBy(css = "[style*='transform: scale(1.077); ']>div")
    private WebElement hoveredProperty;

    public boolean checkThatPropertyIsHovered() {
        return hoveredProperty.isDisplayed() && hoveredProperty.getAttribute("style").contains("color: var(--linaria-theme_palette-white)");
    }

    public void clickOnHoveredProperty() {
        hoveredProperty.click();
    }
}
