package stepdefs;

import Pages.EshopPage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyStepdefs {
    public WebDriver driver;
    WebDriverWait wait;
    EshopPage eshopPage;

    @Before
    public void initializeWebDriver() {
        System.setProperty("webdriver.chrome.driver", "C://Selenium//chromedriver.exe");
        driver = new ChromeDriver();
        eshopPage = new EshopPage(driver);

    }

    @Given("^user logs in with values \"([^\"]*)\" and  \"([^\"]*)\"$")
    public void userLogsInWithValuesAnd(String email, String password) {
        driver.navigate().to("http://automationpractice.com");

        eshopPage.signIn(email, password);
    }

    @When("^go to WomenDept, select random clothing and add to cart$")
    public void goToWomenDeptSelectRandomClothingAndAddToCart() throws InterruptedException {
        eshopPage.addRandomItemToCart();

    }

    @And("^proceed to checkout twice$")
    public void proceedToCheckoutTwice() {
        eshopPage.proceed2Checkout();

    }

    @And("^check delivery and billing address$")
    public void checkDeliveryAndBillingAddress() {
        eshopPage.checkAddresses();

    }

    @And("^proceed to checkout$")
    public void proceedToCheckout() {
    eshopPage.checkout();


    }

    @And("^agree with terms proceed to checkout$")
    public void agreeWithTermsProceedToCheckout() throws InterruptedException {
        eshopPage.setAgreeTerms();

    }

    @And("^select pay by check$")
    public void selectPayByCheck() {
        eshopPage.setPayByCheck();

    }
    @And("^confirm order$")
    public void confirmOrder() {
        eshopPage.setConfirmOrder();

    }

    @Then("^verify order is submitted$")
    public void verifyOrderIsSubmitted() {
        eshopPage.orderSubmitted();


    }


    @And("^back to orders$")
    public void backToOrders() {
        eshopPage.setBack2Orders();

    }

    @And("^verify you have one order and total price is right$")
    public void verifyYouHaveOneOrderAndTotalPriceIsRight() {
        eshopPage.setTotalPriceCheck();


    }

    @And("^log out$")
    public void logOut() {
        eshopPage.setLogOut();
    }

    @After
    public void cleanUp() {
        driver.quit();
    }


}
