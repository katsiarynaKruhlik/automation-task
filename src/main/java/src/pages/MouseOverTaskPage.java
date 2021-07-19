package src.pages;

import static com.codeborne.selenide.Condition.visible;
import com.codeborne.selenide.SelenideElement;
import static src.utils.PageUrls.MOUSE_OVER_URL;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MouseOverTaskPage extends BasePage {

    private static final SelenideElement clickMeBtn = $(byText("Click me"));
    private static final SelenideElement clickCountLocator = $("#clickCount");
    private static final SelenideElement mouseOverLink = $(byLinkText("Mouse Over"));

    public boolean mouseOverPageIsCurrent() {
        mouseOverLink.shouldBe(visible).click();
        return isUrlCorrect(MOUSE_OVER_URL);
    }

    public void makeClicks() {
        clickMeBtn.shouldBe(visible).hover().click();
        clickMeBtn.shouldBe(visible).hover().click();
    }

    public String getNumberOfClicks() {
        String numberOfClicks = clickCountLocator.getText();
        log().info("After 2 clicks: " + numberOfClicks);
        return numberOfClicks;
    }

}
