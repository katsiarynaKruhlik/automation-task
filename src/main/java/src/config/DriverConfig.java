package src.config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverConfig {

    private DriverConfig() {
        throw new IllegalStateException("Config class");
    }

    public static void configuration() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 15000;
        Configuration.timeout = 10000;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("enable-automation");
        options.addArguments("--disable-extensions");
        options.addArguments("--dns-prefetch-disable");
        options.addArguments("--ignore-ssl-errors=yes");
        options.addArguments("--ignore-certificate-errors");
        options.setCapability(ChromeOptions.CAPABILITY, options);
        options.setAcceptInsecureCerts(true);
    }
}