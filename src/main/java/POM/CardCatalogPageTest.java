package POM;

import AbstractComponents.MostOftenUsedMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v119.preload.model.RuleSetErrorType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CardCatalogPageTest extends MostOftenUsedMethods {
    WebDriver driver;

    public CardCatalogPageTest(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }



//        Boolean match=webElementsproducts.stream().anyMatch(s->s.getText().equals("ADIDAS ORIGINAL"));
    @FindBy(css = ".cartSection h3")
    List<WebElement>webElementsproducts;

    public Boolean anyMatchProducts(String name){
        waitAnawayTwhoSeconds();
        Boolean a=webElementsproducts.stream().anyMatch(s->s.getText().equals(name));
        return a;
    }
    @FindBy(xpath = "(//button[@type='button'])[2]")
    WebElement checkoutPage;
    public CheckoutPageTest goToCheckoutPage(){
        waitAnawayTwhoSeconds();
        checkoutPage.click();
        CheckoutPageTest checkoutPageTest=new CheckoutPageTest(driver);
        return checkoutPageTest;
    }
}
