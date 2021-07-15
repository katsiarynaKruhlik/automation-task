package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

import static src.utils.PageUrls.*;
import static src.interfaces.IPageFactory.ajaxDataPage;

public class AjaxDataTaskTest extends BaseTest {

    @Epic(value = "Testing " + BASE_URL)
    @Feature(value = "Test for " + AJAX_DATA_URL)
    @Description("Checks whether test waits for label text to appear after processing AJAX request")
    @Test
    public void waitForLabelToAppear() {
        Assert.assertTrue(ajaxDataPage.ajaxDataPageIsCurrent());
        ajaxDataPage.triggerAjaxRequestButton();
        Assert.assertTrue(ajaxDataPage.isLabelTextAppeared());
    }
}
