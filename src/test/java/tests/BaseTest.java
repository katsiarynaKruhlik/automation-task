package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import src.config.DriverConfig;
import src.interfaces.ILogger;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static src.utils.PageUrls.BASE_URL;
import static com.codeborne.selenide.Selenide.open;


abstract class BaseTest implements ILogger{

    @BeforeTest
    public void start() {
        DriverConfig.configuration();
        log().info("Opening home page");
        open(BASE_URL);
    }

    @AfterTest
    public void finish() {
        log().info("Closing web driver");
        closeWebDriver();
    }

}
