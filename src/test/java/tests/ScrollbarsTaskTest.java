package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.*;
import src.pages.ScrollbarsTaskPage;
import org.openqa.selenium.Point;

public class ScrollbarsTaskTest extends BaseTest {

    @Epic(value = "http://uitestingplayground.com")
    @Feature(value = "http://uitestingplayground.com/scrollbars")
    @Description("This test checks whether hiding button is properly scrolled to be visible")
    @Test
    public void findHidingButton() {
        ScrollbarsTaskPage scrollbarsTaskPage = new ScrollbarsTaskPage();
        scrollbarsTaskPage.navigateTScrollbarsTaskPage()
                .clickScrollbar();
        Point initialHidingButtonLocation = scrollbarsTaskPage.getHidingButtonLocation();
        scrollbarsTaskPage.showHidingButton();
        Point finalHidingButtonLocation = scrollbarsTaskPage.getHidingButtonLocation();
        isHidingButtonInProperPlace(finalHidingButtonLocation);
        Assert.assertNotEquals(finalHidingButtonLocation, initialHidingButtonLocation);
    }

    @Step
    public void isHidingButtonInProperPlace(Point buttonFinalLocation) {
        Point properFinalLocation = new Point(476, 418);
        Assert.assertEquals(properFinalLocation, buttonFinalLocation);
    }
}
