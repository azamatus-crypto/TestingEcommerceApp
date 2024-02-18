package AbstractComponents;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public  class MostOftenUsedMethods {
WebDriver driver;

public MostOftenUsedMethods(WebDriver driver){
    this.driver=driver;
}



    public void waitUntilElementisAppear(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public void waitAnawayTwhoSeconds(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void scrollWindowsDown(WebDriver driver){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)");
    }

}
