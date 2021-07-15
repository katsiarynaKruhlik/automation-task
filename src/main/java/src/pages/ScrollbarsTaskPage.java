package src.pages;

import static com.codeborne.selenide.Condition.visible;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Point;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static src.utils.PageUrls.SCROLLBARS_URL;

public class ScrollbarsTaskPage extends BasePage{

    private static final SelenideElement hidingBtn = $("#hidingButton");
    private static final SelenideElement scrollbarsLink = $(byLinkText("Scrollbars"));

    public boolean scrollbarsPageIsCurrent() {
        log().info("Clicking scrollbars");
        scrollbarsLink.shouldBe(visible).click();
        return isUrlCorrect(SCROLLBARS_URL);
    }

    public Point getHidingBtnLocation() {
        log().info("Getting hiding button location");
        return hidingBtn.getLocation();
    }

    public void showHidingBtn() {
        log().info("Scrolling hiding button to center");
        $(hidingBtn).shouldBe(visible)
                .scrollIntoView("{block: \"center\", inline: \"center\"}")
                .click();
    }

}
