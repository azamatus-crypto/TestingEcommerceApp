package stepdefenitions;

import POM.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;

public class SybmitOrderstepdefenitions extends BaseTest {
    public Log_In_Test logInPageTest;
    public ProductsPagesTest producktsPage;
    public CheckoutPageTest page;
    @Given("I launched on Ecomerce page")
    public void i_launched_on_Ecommerce_Page() throws IOException {
        launchApp();
    }
    @Given("^Logged in with User Name (.+) and password (.+)$")
    public void logged_in_userName_and_Password(String username,String password){
        producktsPage = logInPageTest.logIn(username, password);
    }
    @When("^I add the product (.+) to cart$")
    public void i_add_product_to_Cart(String product) throws InterruptedException {
        producktsPage.addProducts(product);
    }
    @And("^Checkout (.+) and submit the order$")
    public void chekout_product_and_submit_the_Order(String product) throws InterruptedException {
        CardCatalogPageTest cardPageCatalog = producktsPage.goToCatalogPage();
        Boolean a = cardPageCatalog.anyMatchProducts(product);
        Assert.assertTrue(a);
        page = cardPageCatalog.goToCheckoutPage();
        page.chooseCountry("Kyrgyzstan");


    }

    @Then("{string} message is displayed on Confirmation page")
    public void messageIsDisplayed(String str) throws InterruptedException {
        page.goToGreetingsPage();
    }

}
