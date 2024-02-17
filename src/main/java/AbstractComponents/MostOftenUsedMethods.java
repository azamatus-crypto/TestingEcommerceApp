package AbstractComponents;

import org.openqa.selenium.WebElement;

public  class MostOftenUsedMethods {




    public void waitUntilElementisAppear(WebElement element){

    }
    public void waitAnawayTwhoSeconds(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
