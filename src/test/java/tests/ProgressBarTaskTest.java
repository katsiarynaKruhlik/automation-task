package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import static src.utils.PageUrls.*;
import static src.interfaces.IPageFactory.progressBarPage;

public class ProgressBarTaskTest extends BaseTest {

    @Epic(value = "Testing " + BASE_URL)
    @Feature(value = "Test for" + PROGRESS_BAR_URL)
    @Test
    public void waitForProgressBar(){
        Assert.assertTrue(progressBarPage.progressBarPageIsCurrent());
        progressBarPage.clickStart();
        progressBarPage.waitTillCondition();
    }
}
