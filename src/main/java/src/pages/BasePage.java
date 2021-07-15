package src.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import src.interfaces.ILogger;
import java.util.concurrent.TimeUnit;



abstract class BasePage implements ILogger {

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

    public static boolean isUrlCorrect(String url) {
        String currentUrl = WebDriverRunner.url();
        return currentUrl.equals(url);
    }
}
