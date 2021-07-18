package src.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static src.utils.PageUrls.CLICK_URL;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ClickTaskPage extends BasePage {

    private static final SelenideElement btnThatIgnoresClick = $("#badButton");
    private static final SelenideElement clickPageLink = $(byXpath("//a[@href=\"/click\"]"));

    public boolean clickPageIsCurrent() {
        clickPageLink.shouldBe(visible).click();
        return isUrlCorrect(CLICK_URL);
    }

    public void makeClick() {
        btnThatIgnoresClick.shouldBe(visible).click();
    }

    public boolean btnNotClicked() {
        String btnClass = btnThatIgnoresClick.getAttribute("class");
        log().info("Check whether button is not clicked");
        assert btnClass != null;
        return btnClass.equals("btn btn-primary");

    }

    public boolean btnInClickedState() {
        String btnClass = btnThatIgnoresClick.getAttribute("class");
        log().info("Check whether button is clicked");
        assert btnClass != null;
        return btnClass.equals("btn btn-success");
    }

}
