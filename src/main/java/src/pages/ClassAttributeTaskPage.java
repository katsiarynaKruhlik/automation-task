package src.pages;

import static com.codeborne.selenide.Condition.visible;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.switchTo;
import static src.utils.PageUrls.CLASS_ATTRIBUTE_URL;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ClassAttributeTaskPage extends BasePage {

    private static final SelenideElement correctPrimaryBtnLocator =
            $(byXpath("//button[contains(concat(' ', normalize-space(@class), ' '), ' btn-primary ')]"));
    private static final SelenideElement incorrectPrimaryBtnLocator =
            $(byXpath("//button[@class='btn-primary']"));
    private static final SelenideElement classAttributeLink = $(byLinkText("Class Attribute"));


    public boolean classAttrPageIsCurrent() {
        log().info("Opening Class attribute page");
        classAttributeLink.shouldBe(visible).click();
        return isUrlCorrect(CLASS_ATTRIBUTE_URL);
    }

    public void acceptAlert() {
        correctPrimaryBtnLocator.shouldBe(visible).click();
        sleep(1);
        switchTo().alert().accept();
        sleep(2);
    }

    public void findIncorrectLocator() {
        log().info("Trying to click incorrect locator");
        incorrectPrimaryBtnLocator.shouldBe(Condition.exist, Duration.ofMillis(100));
    }
}
