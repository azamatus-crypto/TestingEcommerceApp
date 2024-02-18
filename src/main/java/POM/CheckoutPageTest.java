package POM;

import AbstractComponents.MostOftenUsedMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPageTest extends MostOftenUsedMethods {
    WebDriver driver;

    public CheckoutPageTest(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

   @FindBy(xpath = "//input[@placeholder='Select Country']")
    WebElement countryelement;
    @FindBy(css = "button[class='ta-item list-group-item ng-star-inserted']")
    List<WebElement>countryElements;

//        Thread.sleep(1000);
//        kyrelement.click();
    public void chooseCountry(String countryName){
        countryelement.sendKeys("Kyr");
        waitAnawayTwhoSeconds();
        WebElement kyrgyzstan=countryElements.stream().filter(s->s.getText().equals(countryName)).findFirst().orElse(null);
        waitAnawayTwhoSeconds();
        kyrgyzstan.click();
       scrollWindowsDown(driver);
       waitAnawayTwhoSeconds();
    }
    @FindBy(css = "[class='btnn action__submit ng-star-inserted']")
    WebElement elementgreetings;
    public GreetingsTest goToGreetingsPage(){
        elementgreetings.click();
        GreetingsTest greetingsTest=new GreetingsTest(driver);
        return greetingsTest;
    }

}
