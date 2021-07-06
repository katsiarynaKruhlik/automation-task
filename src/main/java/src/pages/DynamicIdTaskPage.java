package src.pages;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DynamicIdTaskPage extends BasePage{

    private final static String buttonWithDynamicIdLocator = "Button with Dynamic ID";

    public DynamicIdTaskPage clickButtonWithDynamicIdLocator() {
        log().info("Clicking button with dynamic ID");
        $(byText(buttonWithDynamicIdLocator)).shouldBe(Condition.visible).click();
        return this;
    }

    public String getButtonId() {
        String id = $(byText(buttonWithDynamicIdLocator)).getAttribute("id");
        String logOutputString = String.format("Button ID: %s", id);
        log().info(logOutputString);
        return id;
    }

}
