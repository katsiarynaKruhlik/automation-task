package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import static src.interfaces.IPageFactory.dynamicTablePage;
import static src.utils.PageUrls.*;

public class DynamicTableTaskTest extends BaseTest {

    @Epic(value = "Testing " + BASE_URL)
    @Feature(value = "Test for " + DYNAMIC_TABLE_URL)
    @Test
    public void compareValuesOfCPU() {
        Assert.assertTrue(dynamicTablePage.dynamicTablePageIsCurrent());
        Assert.assertTrue(dynamicTablePage.valuesAreSame());
    }
}
