package tests;

import com.codeborne.selenide.ex.ElementNotFound;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import static src.interfaces.IPageFactory.classAttributePage;
import static src.utils.PageUrls.*;

public class ClassAttributeTaskTest extends BaseTest {

    @Epic(value = "Testing " + BASE_URL)
    @Feature(value = "Test for" + CLASS_ATTRIBUTE_URL)
    @Test
    public void checkPrimaryBtnLocator() {
        Assert.assertTrue(classAttributePage.classAttrPageIsCurrent());
        classAttributePage.acceptAlert();
        Assert.assertThrows(ElementNotFound.class, classAttributePage::findIncorrectLocator);

    }
}
