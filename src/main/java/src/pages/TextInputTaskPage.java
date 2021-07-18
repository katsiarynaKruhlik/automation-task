package src.pages;

import static com.codeborne.selenide.Condition.visible;
import com.codeborne.selenide.SelenideElement;
import static src.utils.PageUrls.TEXT_INPUT_URL;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;

public class TextInputTaskPage extends BasePage {

    private static final SelenideElement textInputLocator = $("#newButtonName");
    private static final SelenideElement changingNameBtn = $("#updatingButton");
    private static final SelenideElement textInputLink = $(byLinkText("Text Input"));

    public boolean textInputPageIsCurrent() {
        textInputLink.shouldBe(visible).click();
        return isUrlCorrect(TEXT_INPUT_URL);

    }

    public void inputBtnName() {
        textInputLocator.sendKeys("Fun button");
        changingNameBtn.shouldBe(visible).click();
    }

    public String getBtnName() {
        return changingNameBtn.getText();
    }
}
