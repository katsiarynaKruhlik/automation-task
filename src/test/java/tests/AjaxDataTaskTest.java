package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.pages.AjaxDataTaskPage;

public class AjaxDataTaskTest extends BaseTest {

    @Epic(value = "Testing http://uitestingplayground.com/")
    @Feature(value = "Test for http://uitestingplayground.com/ajax")
    @Description("Checks whether test waits for label text to appear after processing AJAX request")
    @Test
    public void isLabelTextAppeared() {
        AjaxDataTaskPage ajaxDataTaskPage = new AjaxDataTaskPage();
        ajaxDataTaskPage.navigateToAjaxDataTaskPage()
                .triggerAjaxRequestButton()
                .waitUntilLabelTextAppears();
        Assert.assertTrue(ajaxDataTaskPage.isLabelTextAppeared());

    }
}
