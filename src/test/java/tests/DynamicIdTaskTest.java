package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.*;
import static src.utils.PageUrls.*;
import static src.interfaces.IPageFactory.dynamicIdPage;

public class DynamicIdTaskTest extends BaseTest {

    @Epic(value = "Testing " + BASE_URL)
    @Feature(value = "Test for" + DYNAMIC_ID_URL)
    @Description("Checks whether button has dynamic ID")
    @Test
    public void compareBtnDynamicId() {
        Assert.assertTrue(dynamicIdPage.dynamicIdPageIsCurrent());
        dynamicIdPage.clickBtnWithDynamicId();
        String initialBtnId = dynamicIdPage.getBtnId();
        dynamicIdPage.refreshPage();
        dynamicIdPage.clickBtnWithDynamicId();
        String finalBtnId = dynamicIdPage.getBtnId();
        Assert.assertNotEquals(initialBtnId, finalBtnId);
    }

}
