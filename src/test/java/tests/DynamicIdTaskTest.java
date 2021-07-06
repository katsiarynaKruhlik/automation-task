package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.*;
import src.pages.DynamicIdTaskPage;

public class DynamicIdTaskTest extends BaseTest {

    @Epic(value = "Testing http://uitestingplayground.com/")
    @Feature(value = "http://uitestingplayground.com/dynamicid")
    @Description("Checks whether button has dynamic ID")
    @Test
    public void compareButtonDynamicId() {
        DynamicIdTaskPage dynamicIdTaskPage = new DynamicIdTaskPage();
        dynamicIdTaskPage.navigateToDynamicIdTaskPage();
        dynamicIdTaskPage.clickButtonWithDynamicIdLocator();
        String initialButtonId = dynamicIdTaskPage.getButtonId();
        dynamicIdTaskPage.refreshPage();
        dynamicIdTaskPage.clickButtonWithDynamicIdLocator();
        String finalButtonId = dynamicIdTaskPage.getButtonId();
        Assert.assertNotEquals(initialButtonId, finalButtonId);
    }

}
