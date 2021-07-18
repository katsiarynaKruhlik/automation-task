package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import static src.utils.PageUrls.*;
import static src.interfaces.IPageFactory.mouseOverPage;

public class MouseOverTaskTest extends BaseTest {

    @Epic(value = "Testing " + BASE_URL)
    @Feature(value = "Test for" + MOUSE_OVER_URL)
    @Description("Check whether link is clickable after hovering")
    @Test
    public void isLinkClickable(){
        Assert.assertTrue(mouseOverPage.mouseOverPageIsCurrent());
        mouseOverPage.makeClicks();
        Assert.assertEquals(mouseOverPage.getNumberOfClicks(), "2");

    }
}
