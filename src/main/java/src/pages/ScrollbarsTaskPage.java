package src.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.Point;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ScrollbarsTaskPage extends BasePage{

    private static final String hidingButtonLocator = "#hidingButton";
    private static final String scrollbarsLocator = "/html/body/section/div/div";

    public void clickScrollbar() {
        log().info("Clicking scrollbar");
        $(byXpath(scrollbarsLocator)).shouldBe(Condition.visible).click();
    }

    public Point getHidingButtonLocation() {
        log().info("Getting hiding button location");
        return $(hidingButtonLocator).getLocation();
    }

    public void showHidingButton() {
        log().info("Scrolling hiding button to center");
        $(hidingButtonLocator).shouldBe(Condition.visible)
                .scrollIntoView("{block: \"center\", inline: \"center\"}")
                .click();
    }

}
