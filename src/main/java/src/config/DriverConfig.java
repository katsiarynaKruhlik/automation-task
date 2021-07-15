package src.config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverConfig {

    public static void configuration() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 10000;
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        options.addArguments("--dns-prefetch-disable");
        options.addArguments("--ignore-ssl-errors=yes");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("disable-extensions");
        options.setCapability(ChromeOptions.CAPABILITY, options);
        options.setAcceptInsecureCerts(true);
    }
}