package stepdefenitions;

import POM.BaseTest;
import POM.Log_In_Test;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class ErrorValidationsStepdefenitions extends BaseTest {
    Log_In_Test logInTest;

    @Given("launched on ecomerce app")
    public void launchApplication(){
        launchApplication();
    }

    @Given("^usrname (.+) ang (.+)$")
    public void logIn(String name,String password){
        logInTest.logIn(name, password);
    }
    @Then("i recived message {string} message is displayed")
    public void getTheMessage(String str){
        Assert.assertEquals(str,logInTest.getErrorMESSAGE());
    }
}
