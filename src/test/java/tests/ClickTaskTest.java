package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import static src.interfaces.IPageFactory.clickPage;
import static src.utils.PageUrls.*;

public class ClickTaskTest extends BaseTest {

    @Epic(value = "Testing " + BASE_URL)
    @Feature(value = "Test for " + CLICK_URL)
    @Test
    public void checkClick() {
        Assert.assertTrue(clickPage.clickPageIsCurrent());
        Assert.assertTrue(clickPage.btnNotClicked());
        clickPage.makeClick();
        Assert.assertTrue(clickPage.btnInClickedState());
    }

}
