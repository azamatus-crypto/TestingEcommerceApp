package POM;

import AbstractComponents.MostOftenUsedMethods;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrorValidationsTest extends BaseTest {
    private final String userName = "azache@gmail.com";
    private final String passwprde = "1234567@Aza";


    @Test(groups = {"error handling"},retryAnalyzer = RetryClass.class)
    public void inCorrectLogin() throws InterruptedException {
        logInTest.logIn(userName, passwprde);
        Thread.sleep(1000);
        Assert.assertEquals("Incorrect email or password.", logInTest.getErrorMESSAGE());
    }
    @Test
    public void productErrorValidations() {
        ProductsPagesTest productsPagesTest = logInTest.logIn("azacher@gmail.com", "1234567@Aza");
        productsPagesTest.addProducts("ADIDAS ORIGINAL");
        CardCatalogPageTest cardCatalogPageTest = productsPagesTest.goToCatalogPage();
        Boolean matching = cardCatalogPageTest.anyMatchProducts("ZARA COAT");
        Assert.assertFalse(matching);
    }
}
