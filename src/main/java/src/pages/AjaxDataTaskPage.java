package src.pages;

import static com.codeborne.selenide.Condition.visible;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static src.utils.PageUrls.AJAX_DATA_URL;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AjaxDataTaskPage extends BasePage {

    private final static SelenideElement buttonTriggeringAjaxRequest = $("#ajaxButton");
    private final static SelenideElement labelText = $(byText("Data loaded with AJAX get request."));
    private static final SelenideElement ajaxDataLink = $(byLinkText("AJAX Data"));

    public boolean ajaxDataPageIsCurrent() {
        ajaxDataLink.shouldBe(visible).click();
        return isUrlCorrect(AJAX_DATA_URL);
    }

    public void triggerAjaxRequestButton() {
        log().info("Clicking AJAX request button");
        buttonTriggeringAjaxRequest.shouldBe(visible).click();
    }

    public boolean isLabelTextAppeared() {
        log().info("Waiting for Label text to appear");
        return labelText.shouldBe(visible, Duration.ofSeconds(16)).is(visible);

    }

}
