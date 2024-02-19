package POM;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;


public class SubmitOrderPageObject extends BaseTest {
    @Test(dataProvider = "getData")
    public  void submitOrder(HashMap<String,String>map) throws InterruptedException {
        ProductsPagesTest productsPagesTest = logInTest.logIn(map.get("username"), map.get("password"));
        Thread.sleep(2000);
        productsPagesTest.addProducts(map.get("product"));
        CardCatalogPageTest catalogPageTest = productsPagesTest.goToCatalogPage();
        Boolean match = catalogPageTest.anyMatchProducts(map.get("product"));
        Assert.assertTrue(match);
        CheckoutPageTest checkoutPageTest = catalogPageTest.goToCheckoutPage();
        checkoutPageTest.chooseCountry("Kyrgyzstan");
        GreetingsTest greetingsTest = checkoutPageTest.goToGreetingsPage();
        Boolean eqvalsToText = greetingsTest.greetingsMatch("THANKYOU FOR THE ORDER.");
        Assert.assertTrue(eqvalsToText);

    }
    @DataProvider
    public Object[][]getData() throws IOException {
        List<HashMap<String,String>>mapper=getJsonData("C:\\Users\\Lenovo\\TestingEcommerceApp\\src\\main\\java\\JSONfiles\\UserNameAndPassword.json");
        return new Object[][]{{mapper.get(0)},{mapper.get(1)}};
    }
    @Test(dependsOnMethods = {"submitOrder"},dataProvider = "getData")
    public void orderHistoryTest(String username,String password,String product) throws IOException, InterruptedException {
        ProductsPagesTest producktsPage = logInTest.logIn(username,password);
        OrderPage orderPage=new OrderPage(driver);
        orderPage.goToOrderPage();
        Assert.assertTrue(orderPage.verifyOrderisDispleys(product));
    }


}
