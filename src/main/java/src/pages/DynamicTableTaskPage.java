package src.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$$;
import static src.utils.PageUrls.DYNAMIC_TABLE_URL;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import java.util.List;

public class DynamicTableTaskPage extends BasePage {

    private final static SelenideElement chromeLabelLocator = $(withText("Chrome CPU:"));
    private final static List<SelenideElement> tableElemsList = $$(byXpath("//*[(text()=\"Chrome\")]/following-sibling::*"));
    private static final SelenideElement dynamicTableLink = $(byLinkText("Dynamic Table"));

    public boolean dynamicTablePageIsCurrent() {
        dynamicTableLink.shouldBe(Condition.visible).click();
        return isUrlCorrect(DYNAMIC_TABLE_URL);
    }

    private String getChromeLabelValue() {
        String chromeLabelText = chromeLabelLocator.getText();
        return (chromeLabelText.split(": ", 2))[1];
    }

    public boolean valuesAreSame() {
        String chromeLabelValue = getChromeLabelValue();
        for (SelenideElement elem : tableElemsList) {
            String elemText = elem.getText();
            if (elemText.equals(chromeLabelValue)) {
                return true;
            }
        }
        return false;
    }
}
