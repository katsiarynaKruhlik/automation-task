package src.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.ElementClickInterceptedException;

import static com.codeborne.selenide.Selenide.$;

public class VisibilityTaskPage extends BasePage {
    private static final String hideButtonLocator = "#hideButton";

    private static final String removedButtonLocator = "#removedButton";
    private static final String zeroWidthButtonLocator = "#zeroWidthButton";
    private static final String overlappedButtonLocator = "#overlappedButton";
    private static final String hidingLayerLocator = "#hidingLayer";
    private static final String transparentButtonLocator = "#transparentButton";
    private static final String invisibleButtonLocator = "#invisibleButton";
    private static final String notDisplayedButtonLocator = "#notdisplayedButton";
    private static final String offscreenButtonLocator = "#offscreenButton";


    public VisibilityTaskPage clickHideButton() {
        log().info("Hiding buttons");
        $(hideButtonLocator).shouldBe(Condition.visible).click();
        return this;
    }

    public boolean isRemovedButtonVisible() {
        return $(removedButtonLocator).exists();  //.shouldBe(Condition.exist)
    }

    private static double parseLocatorSizeValue(String locator, String valueType) {
        String rawValue = $(locator).getCssValue(valueType);
        String stringValue = rawValue.split("p", 2)[0];
        return Double.parseDouble(stringValue);
    }

    public boolean isZeroWidthButtonVisible() {
        double buttonWidth = parseLocatorSizeValue(zeroWidthButtonLocator, "width");
        return buttonWidth > 0.0;
    }

    public boolean isOverlappedButtonVisible() {
        log().info("Checking whether hiding layer exists and button is overlapped");
        boolean locationOfElementsIsSame = ($(hidingLayerLocator).getLocation()).equals($(overlappedButtonLocator).getLocation());
        boolean hidingLayerIsTransparent = ($(hidingLayerLocator).getCssValue("color").equals("rgba(0, 0, 0, 0)"));
        return (!locationOfElementsIsSame) &&
                (hidingLayerIsTransparent);
    }

    public boolean isTransparentButtonVisible() {
        return Integer.parseInt($(transparentButtonLocator).getCssValue("opacity")) > 0;
    }

    public boolean isInvisibleButtonVisible() {
        return !($(invisibleButtonLocator).getCssValue("visibility")).equals("hidden");
    }

    public boolean isNotDisplayedButtonVisible() {
        return !($(notDisplayedButtonLocator).getCssValue("display").equals("none"));
    }

    public boolean isOffscreenButtonVisible() {
        double buttonTop = parseLocatorSizeValue(offscreenButtonLocator, "top");
        double buttonLeft = parseLocatorSizeValue(offscreenButtonLocator, "left");
        return (buttonTop > -0010.0) || (buttonLeft > -0080.0);
    }

}
