package tests;

import com.codeborne.selenide.ex.InvalidStateException;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import static src.interfaces.IPageFactory.hiddenLayersPage;
import static src.utils.PageUrls.*;

public class HiddenLayerTaskTest extends BaseTest {

    @Epic(value = "Testing " + BASE_URL)
    @Feature(value = "Test for" + HIDDEN_LAYERS_URL)
    @Test
    public void checkIfBtnIsClickable() {
        Assert.assertTrue(hiddenLayersPage.hiddenLayersPageIsCurrent());
        Assert.assertThrows(InvalidStateException.class, hiddenLayersPage::clickGreenBtn);

    }
}
