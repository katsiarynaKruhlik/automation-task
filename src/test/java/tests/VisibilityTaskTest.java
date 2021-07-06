package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.*;
import src.pages.VisibilityTaskPage;

public class VisibilityTaskTest extends BaseTest {

    @Epic(value = "Testing http://uitestingplayground.com/")
    @Feature(value = "Test for http://uitestingplayground.com/visibility")
    @Description("Checks whether all buttons are hidden")
    @Test
    public void checkVisibilityOfAllButtons() {
        VisibilityTaskPage visibilityTaskPage = new VisibilityTaskPage();
        visibilityTaskPage.navigateToVisibilityTaskPage()
                .clickHideButton();

        Assert.assertFalse(visibilityTaskPage.isRemovedButtonVisible());

        Assert.assertFalse(visibilityTaskPage.isZeroWidthButtonVisible());

        Assert.assertFalse(visibilityTaskPage.isOverlappedButtonVisible());

        Assert.assertFalse(visibilityTaskPage.isTransparentButtonVisible());

        Assert.assertFalse(visibilityTaskPage.isInvisibleButtonVisible());

        Assert.assertFalse(visibilityTaskPage.isNotDisplayedButtonVisible());

        Assert.assertFalse(visibilityTaskPage.isOffscreenButtonVisible());
    }

}
