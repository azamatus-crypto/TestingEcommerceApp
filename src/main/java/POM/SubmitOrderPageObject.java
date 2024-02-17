package POM;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;


public class SubmitOrderPageObject {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\EndToEndTestEcommerceApp\\src\\main\\java\\drivers\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/client");
        driver.manage().window().maximize();
        driver.findElement(By.id("userEmail")).sendKeys("azacher@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("1234567@Aza");
        driver.findElement(By.id("login")).click();
        Thread.sleep(2000);
        List<WebElement>namesOfProducts=driver.findElements(By.cssSelector(".card-body"));
        WebElement a=namesOfProducts.stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
        a.findElement(By.cssSelector("button[class='btn w-10 rounded']")).click();
//        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(4));
//        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div[class='py-2 border-bottom ml-3'] input[placeholder='search']")).sendKeys("IPHONE 13 PRO",Keys.ENTER);
        Thread.sleep(5000);
        List<WebElement>elementNotPresent=driver.findElements(By.cssSelector(".card-body"));
        Boolean presentAddidas=elementNotPresent.stream().anyMatch(s->s.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL"));
        Boolean presentZaracoat=elementNotPresent.stream().anyMatch(s->s.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3"));
        Assert.assertFalse(presentAddidas);
        Assert.assertFalse(presentZaracoat);
        driver.findElement(By.cssSelector("div[class='py-2 border-bottom ml-3'] input[placeholder='search']")).sendKeys(Keys.CLEAR);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@class='btn btn-custom'])[3]")).click();
        Thread.sleep(2000);
        List<WebElement>webElementsproducts=driver.findElements(By.cssSelector(".cartSection h3"));
        Boolean match=webElementsproducts.stream().anyMatch(s->s.getText().equals("ADIDAS ORIGINAL"));
        Thread.sleep(2000);
        Assert.assertTrue(match);
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("Kyr");
        Thread.sleep(1000);
        List<WebElement>countryElements=driver.findElements(By.cssSelector("button[class='ta-item list-group-item ng-star-inserted']"));
        WebElement kyrelement=countryElements.stream().filter(s->s.getText().equals("Kyrgyzstan")).findFirst().orElse(null);
        Thread.sleep(1000);
        kyrelement.click();
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[class='btnn action__submit ng-star-inserted']")).click();
        Thread.sleep(1000);
        String greetings=driver.findElement(By.cssSelector(".hero-primary")).getText();
        Assert.assertTrue(greetings.equals("THANKYOU FOR THE ORDER."));











    }


}
