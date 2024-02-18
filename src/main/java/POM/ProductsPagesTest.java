package POM;

import AbstractComponents.MostOftenUsedMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPagesTest extends MostOftenUsedMethods {

    WebDriver driver;

    public ProductsPagesTest(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

//        WebElement a=namesOfProducts.stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
//        a.findElement(By.cssSelector("button[class='btn w-10 rounded']")).click();
////        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(4));
////        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
    @FindBy(css = ".card-body")
    List<WebElement>elementsOfproduckts;
    @FindBy(css = "b")
    By namesofproducts;
    public WebElement getProduckts(String name){
        WebElement a=elementsOfproduckts.stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals(name)).findFirst().orElse(null);
        return a;
    }
    public void addProducts(String name){
    WebElement a=getProduckts(name);
    waitAnawayTwhoSeconds();
    a.findElement(By.cssSelector("button[class='btn w-10 rounded']")).click();
    waitUntilElementisAppear(spinneranim);
    }
   @FindBy(xpath = "(//button[@class='btn btn-custom'])[3]")
   WebElement elementGotOcardPage;
    @FindBy(css = ".ng-animating")
    WebElement spinneranim;
    public CardCatalogPageTest goToCatalogPage(){
        waitAnawayTwhoSeconds();
        elementGotOcardPage.click();
        CardCatalogPageTest cardCatalogPageTest=new CardCatalogPageTest(driver);
        return cardCatalogPageTest;
    }
}
