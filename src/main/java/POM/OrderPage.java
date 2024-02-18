package POM;

import AbstractComponents.MostOftenUsedMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends MostOftenUsedMethods {
    WebDriver driver;
    public OrderPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "tr td:nth-child(3)")
    List<WebElement> myproducktsOrderLists;

    public Boolean verifyOrderisDispleys(String name){
        Boolean mutch=myproducktsOrderLists.stream().anyMatch(s->s.getText().equals(name));
        return mutch;
    }
    public OrderPage goToOrderPage(){
        elementOrders.click();
        OrderPage orderPage=new OrderPage(driver);
        return orderPage;

    }
    @FindBy(css = ".fa.fa-handshake-o")
    WebElement elementOrders;

}
