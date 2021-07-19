package src.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static src.utils.PageUrls.PROGRESS_BAR_URL;

public class ProgressBarTaskPage extends BasePage {

    private static final SelenideElement progressBarLocator = $("#progressBar");
    private static final SelenideElement startBtn = $("#startButton");
    private static final SelenideElement stopBtn = $("#stopButton");
    private static final SelenideElement progressBarLink = $(byLinkText("Progress Bar"));

    public boolean progressBarPageIsCurrent() {
        progressBarLink.shouldBe(visible).click();
        return isUrlCorrect(PROGRESS_BAR_URL);
    }

    public void clickStart() {
        log().info("Click start button");
        startBtn.shouldBe(visible).click();
        stopBtn.shouldBe(visible);
    }

    public String getPercentage() {
        return progressBarLocator.getAttribute("aria-valuenow");
    }

    public void waitTillCondition() {
        Configuration.timeout = 20000;
        int percentage = 25;
        while (percentage < 75) {
            percentage = Integer.parseInt(progressBarLocator.getAttribute("aria-valuenow"));
            if (percentage >= 75) {
                stopBtn.click();
                log().info(getPercentage());

            }
        }

        Configuration.timeout = 10000;

    }
}
