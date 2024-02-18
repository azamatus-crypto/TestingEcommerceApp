package POM;

import AbstractComponents.MostOftenUsedMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Log_In_Test extends MostOftenUsedMethods {
    WebDriver driver;

    public Log_In_Test(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "userEmail")
    WebElement useremail;
    @FindBy(id = "userPassword")
    WebElement passwordelement;
    @FindBy(id = "login")
    WebElement buttonLogIn;

 public ProductsPagesTest logIn(String username,String password){
     useremail.sendKeys(username);
     passwordelement.sendKeys(password);
     buttonLogIn.click();
     ProductsPagesTest productsPagesTest=new ProductsPagesTest(driver);
     return productsPagesTest;
 }
 public void goTowebsite(WebDriver driver){
     driver.get("https://rahulshettyacademy.com/client");
     driver.manage().window().maximize();
 }
    @FindBy(id = "toast-container")
    WebElement errorMesage;
    public String getErrorMESSAGE(){
        return errorMesage.getText().trim();
    }
}
