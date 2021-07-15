package src.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import src.interfaces.ILogger;

public class TestListener implements ITestListener, ILogger {

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        log().info("Taking screenshot...");
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        log().info("___________ " + iTestContext.getName() + " ___________");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        log().info("Test started: " + iTestResult.getMethod().getConstructorOrMethod().getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log().info("Test SUCCESS: " + iTestResult.getMethod().getConstructorOrMethod().getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        takeScreenshot();
        log().error("Test FAILURE: " + iTestResult.getMethod().getConstructorOrMethod().getName());

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        takeScreenshot();
        log().error("Test SKIPPED: " + iTestResult.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        takeScreenshot();
        log().warn("Failed but within success percentage: " + iTestResult.getName());
    }

}
