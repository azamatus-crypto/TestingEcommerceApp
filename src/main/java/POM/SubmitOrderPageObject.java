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
       ProductsPagesTest productsPagesTest=logInTest.logIn(map.get("username"),map.get("password"));
        Thread.sleep(2000);
       productsPagesTest.addProducts(map.get("product"));
       CardCatalogPageTest catalogPageTest=productsPagesTest.goToCatalogPage();
       Boolean match=catalogPageTest.anyMatchProducts(map.get("product"));
       Assert.assertTrue(match);
       CheckoutPageTest checkoutPageTest=catalogPageTest.goToCheckoutPage();
       checkoutPageTest.chooseCountry("Kyrgyzstan");
       GreetingsTest greetingsTest=checkoutPageTest.goToGreetingsPage();
       Boolean eqvalsToText=greetingsTest.greetingsMatch("THANKYOU FOR THE ORDER.");
       Assert.assertTrue(eqvalsToText);
//        Thread.sleep(3000);
//        driver.findElement(By.cssSelector("div[class='py-2 border-bottom ml-3'] input[placeholder='search']")).sendKeys("IPHONE 13 PRO",Keys.ENTER);
//        Thread.sleep(5000);
//        List<WebElement>elementNotPresent=driver.findElements(By.cssSelector(".card-body"));
//        Boolean presentAddidas=elementNotPresent.stream().anyMatch(s->s.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL"));
//        Boolean presentZaracoat=elementNotPresent.stream().anyMatch(s->s.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3"));
//        Assert.assertFalse(presentAddidas);
//        Assert.assertFalse(presentZaracoat);
//        driver.findElement(By.cssSelector("div[class='py-2 border-bottom ml-3'] input[placeholder='search']")).sendKeys(Keys.CLEAR);
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("(//button[@class='btn btn-custom'])[3]")).click();
//        Thread.sleep(2000);
//        List<WebElement>webElementsproducts=driver.findElements(By.cssSelector(".cartSection h3"));
//        Boolean match=webElementsproducts.stream().anyMatch(s->s.getText().equals("ADIDAS ORIGINAL"));
//        Thread.sleep(2000);
//        Assert.assertTrue(match);
//        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
//        driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("Kyr");
//        Thread.sleep(1000);
//        List<WebElement>countryElements=driver.findElements(By.cssSelector("button[class='ta-item list-group-item ng-star-inserted']"));
//        WebElement kyrelement=countryElements.stream().filter(s->s.getText().equals("Kyrgyzstan")).findFirst().orElse(null);
//        Thread.sleep(1000);
//        kyrelement.click();
//        JavascriptExecutor js=(JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,800)");
//        Thread.sleep(1000);
//        driver.findElement(By.cssSelector("[class='btnn action__submit ng-star-inserted']")).click();
//        Thread.sleep(1000);
//        String greetings=driver.findElement(By.cssSelector(".hero-primary")).getText();
//        Assert.assertTrue(greetings.equals("THANKYOU FOR THE ORDER."));

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
