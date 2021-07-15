package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.*;
import static src.interfaces.IPageFactory.scrollbarsPage;
import org.openqa.selenium.Point;
import static src.utils.PageUrls.*;

public class ScrollbarsTaskTest extends BaseTest {

    @Epic(value = "Testing " + BASE_URL)
    @Feature(value = "Test for " + SCROLLBARS_URL)
    @Description("This test checks whether hiding button is properly scrolled to be visible")
    @Test
    public void findHidingButton() {
        Assert.assertTrue(scrollbarsPage.scrollbarsPageIsCurrent());
        Point initialHidingBtnLocation = scrollbarsPage.getHidingBtnLocation();
        scrollbarsPage.showHidingBtn();
        Point finalHidingBtnLocation = scrollbarsPage.getHidingBtnLocation();
        isHidingBtnInProperPlace(finalHidingBtnLocation);
        Assert.assertNotEquals(finalHidingBtnLocation, initialHidingBtnLocation);
    }

    @Step
    public void isHidingBtnInProperPlace(Point btnFinalLocation) {
        Point properFinalLocation = new Point(484, 418);
        Assert.assertEquals(properFinalLocation, btnFinalLocation);
    }
}
