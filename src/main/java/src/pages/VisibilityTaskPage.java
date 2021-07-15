package src.pages;

import static com.codeborne.selenide.Condition.visible;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static src.utils.PageUrls.VISIBILITY_URL;

public class VisibilityTaskPage extends BasePage {
    private static final SelenideElement hideBtn = $("#hideButton");

    private static final SelenideElement removedBtn = $("#removedButton");
    private static final SelenideElement zeroWidthBtn = $("#zeroWidthButton");
    private static final SelenideElement overlappedBtn = $("#overlappedButton");
    private static final SelenideElement hidingLayerLocator = $("#hidingLayer");
    private static final SelenideElement transparentBtn = $("#transparentButton");
    private static final SelenideElement invisibleBtn = $("#invisibleButton");
    private static final SelenideElement notDisplayedBtn = $("#notdisplayedButton");
    private static final SelenideElement offscreenBtn = $("#offscreenButton");

    private static final SelenideElement visibilityLink = $(byLinkText("Visibility"));

    public boolean visibilityPageIsCurrent() {
        log().info("Opening visibility page");
        visibilityLink.shouldBe(visible).click();
        return isUrlCorrect(VISIBILITY_URL);
    }

    private static double parseLocatorSizeValue(SelenideElement locator, String valueType) {
        String rawValue = locator.getCssValue(valueType);
        String stringValue = rawValue.split("p", 2)[0];
        return Double.parseDouble(stringValue);
    }

    public void clickHideBtn() {
        log().info("Hiding buttons");
        hideBtn.shouldBe(visible).click();
    }

    public boolean removedBtnIsVisible() {
        return removedBtn.exists();
    }

    public boolean ZeroWidthBtnIsVisible() {
        log().info("Checking width");
        double buttonWidth = parseLocatorSizeValue(zeroWidthBtn, "width");
        return buttonWidth > 0.0;
    }

    public boolean overlappedBtnIsVisible() {
        log().info("Checking whether hiding layer exists and button is overlapped");
        boolean locationOfElementsIsSame = hidingLayerLocator.getLocation().equals(overlappedBtn.getLocation());
        boolean hidingLayerIsTransparent = hidingLayerLocator.getCssValue("color").equals("rgba(0, 0, 0, 0)");
        return (!locationOfElementsIsSame) &&
                hidingLayerIsTransparent;
    }

    public boolean transparentBtnIsVisible() {
        return Integer.parseInt(transparentBtn.getCssValue("opacity")) > 0;
    }

    public boolean invisibleBtnIsVisible() {
        return !(invisibleBtn.getCssValue("visibility").equals("hidden"));
    }

    public boolean notDisplayedBtnIsVisible() {
        return !(notDisplayedBtn.getCssValue("display").equals("none"));
    }

    public boolean offscreenBtnIsVisible() {
        double buttonTop = parseLocatorSizeValue(offscreenBtn, "top");
        double buttonLeft = parseLocatorSizeValue(offscreenBtn, "left");
        return (buttonTop > -0010.0) || (buttonLeft > -0080.0);
    }

}
