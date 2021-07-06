package src.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import src.interfaces.ILogger;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.*;


abstract class BasePage implements ILogger {

    public static final String visibilityLinkLocator = "a[href=\"/visibility\"]";
    public static final String scrollbarsLinkLocator = "a[href=\"/scrollbars\"]";
    public static final String ajaxLinkLocator = "a[href=\"/ajax\"]";
    public static final String dynamicIdLinkLocator = "a[href=\"/dynamicid\"]";

    public void refreshPage() {
        log().info("Refreshing page");
        Selenide.refresh();
    }

    public void sleep(int sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException ignored) {
        }
    }

    public VisibilityTaskPage navigateToVisibilityTaskPage() {
        log().info("Opening Visibility task page");
        $(visibilityLinkLocator).shouldBe(Condition.visible).click();
        return new VisibilityTaskPage();
    }

    public ScrollbarsTaskPage navigateTScrollbarsTaskPage() {
        log().info("Opening Scrollbars task page");
        $(scrollbarsLinkLocator).shouldBe(Condition.visible).click();
        return new ScrollbarsTaskPage();
    }

    public AjaxDataTaskPage navigateToAjaxDataTaskPage() {
        log().info("Opening AJAX data task page");
        $(ajaxLinkLocator).shouldBe(Condition.visible).click();
        return new AjaxDataTaskPage();
    }

    public DynamicIdTaskPage navigateToDynamicIdTaskPage() {
        log().info("Opening Dynamic ID task page");
        $(dynamicIdLinkLocator).shouldBe(Condition.visible).click();
        return new DynamicIdTaskPage();
    }

}
