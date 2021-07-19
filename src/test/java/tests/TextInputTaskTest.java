package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import static src.utils.PageUrls.*;
import static src.interfaces.IPageFactory.textInputPage;

public class TextInputTaskTest extends BaseTest {

    @Epic(value = "Testing " + BASE_URL)
    @Feature(value = "Test for" + TEXT_INPUT_URL)
    @Description("Check whether button name changes after text input")
    @Test
    public void renameBtn(){
        Assert.assertTrue(textInputPage.textInputPageIsCurrent());
        textInputPage.inputBtnName();
        Assert.assertEquals(textInputPage.getBtnName(), "Fun button");

    }
}
