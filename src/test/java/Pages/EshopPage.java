package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Random;

public class EshopPage {
    String priceTotal;

    WebDriver driver;
    WebDriverWait wait;

    public EshopPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }



    @FindBy(xpath = "//a [contains (text(),'Sign in') ]")
    WebElement signIn;
    @FindBy(id = "email")
    WebElement email;
    @FindBy(id = "passwd")
    WebElement password;
    @FindBy(id = "SubmitLogin")
    WebElement submit;
    @FindBy(xpath = "//a[contains(text(), 'Women')]")
    WebElement womenDept;
    @FindBys(@FindBy(xpath = "(//a[@class='product_img_link'])"))
    List<WebElement> listings;
    @FindBy(xpath = "//*[@id='add_to_cart']/button")
    WebElement add2Cart;
    @FindBy(xpath = "//*[@id='layer_cart']//a")
    WebElement checkout1;
    @FindBy(css = "#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium")
    WebElement checkout2;
    @FindBys(@FindBy(id = "address_delivery"))
    WebElement deliveryAddress;
    @FindBy(id = "address_invoice")
    WebElement addressBilling;
    @FindBy(xpath = "//*[@id='center_column']//button")
    WebElement checkout3;
    @FindBy(xpath = "//*[@id='cgv']")
    WebElement agreeTerms;
    @FindBy(xpath = "//*[@id='form']/p/button")
    WebElement checkout4;
    @FindBy(xpath = "//*[@id='HOOK_PAYMENT']/div[2]/div/p/a")
    WebElement payByCheck;
    @FindBy(xpath = "//*[@id='cart_navigation']/button")
    WebElement confirmOrder;
    @FindBy(xpath = "//*[@id='center_column']//strong")
    WebElement price;
    @FindBy(xpath = "//*[text()='Your order on My Store is complete.']")
    WebElement successmsg;
    @FindBy(xpath = "//*[text()='Back to orders']")
    WebElement back2Orders;
    @FindBy(tagName = "tr")
    WebElement itemQuantity;
    @FindBy(xpath = "//*//*[@id='order-list']/tbody/tr[1]/td[3]")
    WebElement totalPriceCheck;
    @FindBy(className = "logout")
    WebElement logOut;


    public void signIn(String email, String password) {
        signIn.click();
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        submit.click();

    }

    public void addRandomItemToCart() throws InterruptedException {
        womenDept.click();
        Random random = new Random();
        int num = random.nextInt(listings.size() - 1) + 1;
        int numFrames = driver.findElements(By.tagName("iframe")).size();
        WebElement details = listings.get(num);
        details.click();
        if(numFrames != 0) {
            driver.switchTo().frame(0);
            Thread.sleep(3000);
        }

//        driver.switchTo().frame(0);
        Thread.sleep(5000);
        add2Cart.click();
//        driver.switchTo().defaultContent();
        Thread.sleep(5000);
    }

    public void proceed2Checkout() {
        checkout1.click();
        checkout2.click();
    }

    public void checkAddresses() {
        List<WebElement> address1 = deliveryAddress.findElements(By.tagName("li"));
        List<WebElement> address2 = addressBilling.findElements(By.tagName("li"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(address1, address2);

    }

    public void checkout() {
        checkout3.click();

    }

    public void setAgreeTerms() throws InterruptedException {
      //  wait.until(ExpectedConditions.elementToBeClickable(getAgreeTerms()));
        agreeTerms.click();
        checkout4.click();

    }

    public void setPayByCheck() {
        payByCheck.click();
    }

    public void setConfirmOrder() {
        confirmOrder.click();
    }

    public void orderSubmitted() {
        priceTotal = price.getText();
        String orderMsg = successmsg.getText();
        String successMsg1 = "Your order on My Store is complete.";
        SoftAssert orderCompleteVerify = new SoftAssert();
        orderCompleteVerify.assertEquals(orderMsg, successMsg1);

    }
    public void setBack2Orders () {
        back2Orders.click();
    }
    public void setTotalPriceCheck () {
        SoftAssert itemQuantityVerify = new SoftAssert();
        String itemNum = itemQuantity.getText();
        itemQuantityVerify.assertEquals(itemNum, "2");
        String totalPrice = totalPriceCheck.getText();
        SoftAssert priceVerify = new SoftAssert();
        priceVerify.assertEquals(totalPrice, priceTotal);

    }
    public void setLogOut () {
        logOut.click();
    }

}
