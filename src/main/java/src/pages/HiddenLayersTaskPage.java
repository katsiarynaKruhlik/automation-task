package src.pages;

import static com.codeborne.selenide.Condition.visible;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import static src.utils.PageUrls.HIDDEN_LAYERS_URL;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;

public class HiddenLayersTaskPage extends BasePage {
    private static final SelenideElement greenBtn = $("#greenButton");
    private static final SelenideElement blueBtn = $("#blueButton");
    private static final SelenideElement hiddenLayersLink = $(byLinkText("Hidden Layers"));

    public boolean hiddenLayersPageIsCurrent() {
        hiddenLayersLink.shouldBe(visible).click();
        return isUrlCorrect(HIDDEN_LAYERS_URL);
    }

    public void clickGreenBtn() {
        greenBtn.shouldBe(visible).click();
        log().info("The next click cannot be performed");
        greenBtn.shouldBe(visible);
        Configuration.timeout = 500;
        greenBtn.click();
        Configuration.timeout = 10000;

    }
}
