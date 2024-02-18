package POM;

import AbstractComponents.MostOftenUsedMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GreetingsTest extends MostOftenUsedMethods {
WebDriver driver;

    @FindBy(css = ".hero-primary")
    WebElement elementgreetings;

    public GreetingsTest(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public Boolean greetingsMatch(String greetings){
        waitAnawayTwhoSeconds();
        String gret=elementgreetings.getText().toUpperCase();
        Boolean match=gret.equals(greetings);
        return match;
    }

//        Thread.sleep(1000);
//        String greetings=driver.findElement(By.cssSelector(".hero-primary")).getText();
//        Assert.assertTrue(greetings.equals(""));
}
