package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.*;
import static src.interfaces.IPageFactory.visibilityPage;
import static src.utils.PageUrls.*;

public class VisibilityTaskTest extends BaseTest {

    @Epic(value = "Testing " + BASE_URL)
    @Feature(value = "Test for " + VISIBILITY_URL)
    @Description("Checks whether all buttons are hidden")
    @Test
    public void checkVisibilityOfAllButtons() {
        Assert.assertTrue(visibilityPage.visibilityPageIsCurrent());
        visibilityPage.clickHideBtn();

        Assert.assertFalse(visibilityPage.removedBtnIsVisible());

        Assert.assertFalse(visibilityPage.ZeroWidthBtnIsVisible());

        Assert.assertFalse(visibilityPage.overlappedBtnIsVisible());

        Assert.assertFalse(visibilityPage.transparentBtnIsVisible());

        Assert.assertFalse(visibilityPage.invisibleBtnIsVisible());

        Assert.assertFalse(visibilityPage.notDisplayedBtnIsVisible());

        Assert.assertFalse(visibilityPage.offscreenBtnIsVisible());
    }

}
