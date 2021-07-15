package src.pages;

import static com.codeborne.selenide.Condition.visible;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static src.utils.PageUrls.DYNAMIC_ID_URL;

public class DynamicIdTaskPage extends BasePage{

    private final static SelenideElement btnWithDynamicId = $(byText("Button with Dynamic ID"));
    private final static SelenideElement dynamicIdLink = $(byLinkText("Dynamic ID"));

    public boolean dynamicIdPageIsCurrent() {
        dynamicIdLink.shouldBe(visible).click();
        return isUrlCorrect(DYNAMIC_ID_URL);
    }

    public void clickBtnWithDynamicId() {
        log().info("Clicking button with dynamic ID");
        btnWithDynamicId.shouldBe(visible).click();
    }

    public String getBtnId() {
        String id = btnWithDynamicId.getAttribute("id");
        String logOutputString = String.format("Button ID: %s", id);
        log().info(logOutputString);
        return id;
    }

}
