package src.pages;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AjaxDataTaskPage extends BasePage {

    private  final static String buttonTriggeringAjaxRequestLocator = "#ajaxButton";
    private final static String labelText = "Data loaded with AJAX get request.";

    public AjaxDataTaskPage triggerAjaxRequestButton() {
        log().info("Clicking AJAX request button");
        $(buttonTriggeringAjaxRequestLocator).shouldBe(Condition.visible).click();
        return this;
    }

    public boolean isLabelTextAppeared() {
        return $(byText(labelText)).shouldBe(Condition.visible).isDisplayed();
    }

    public void waitUntilLabelTextAppears() {
        log().info("Waiting for Label text to appear");
/*        Configuration.timeout = 15009;
        $(byText(labelText)).shouldBe(Condition.visible);
*/
        sleep(16);
    }

}
