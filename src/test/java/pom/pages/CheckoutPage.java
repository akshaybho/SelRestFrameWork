package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.base.BasePage;
import pom.objects.BillingAddress;

public class CheckoutPage extends BasePage {
    private final By firstName = By.cssSelector("#billing_first_name");
    private final By lastName = By.cssSelector("#billing_last_name");
    private final By billingAddress = By.xpath(" //input[@id ='billing_address_1']");
    private final By billingCity = By.xpath("//input[@id = 'billing_city']");
    private final By billingZipCode = By.xpath("//p[@id = 'billing_postcode_field']/span/input");
    private final By billingemailId = By.xpath("//input[@id = 'billing_email']");
    private final By placeorderBtn = By.xpath("(//button[contains(@type, 'submit')])[3]");
    private final By successnotice = By.cssSelector(".woocommerce-notice");
    private final By loginLink = By.cssSelector("a.showlogin");
    private final By userName = By.cssSelector("#username");
    private final By passWord = By.cssSelector("#password");
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    public CheckoutPage clickOnLoginLink()
    {
        driver.findElement(loginLink).click();
        return this;
    }
    public CheckoutPage enterUserName(String name)
    {
        driver.findElement(userName).sendKeys(name);
        return this;
    }
    public CheckoutPage enterPassword(String pass)
    {
        driver.findElement(passWord).sendKeys(pass);
        return this;
    }
    public CheckoutPage enterFirstName(String firstname)
    {
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(firstname);
        return this;
    }
    public CheckoutPage enterLastName(String lastname)
    {
        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(lastname);
        return this;
    }
    public CheckoutPage enterAddressLineOne(String address)
    {
        driver.findElement(billingemailId).clear();
        driver.findElement(billingAddress).sendKeys(address);
        return this;
    }
    public CheckoutPage enterCity(String city)
    {
        driver.findElement(billingCity).clear();
        driver.findElement(billingCity).sendKeys(city);
        return this;
    }
    public CheckoutPage enterPostCode(String pincode)
    {
        driver.findElement(billingZipCode).clear();
        driver.findElement(billingZipCode).sendKeys(pincode);
        return this;
    }
    public CheckoutPage enterEmailId(String email)
    {
        driver.findElement(billingemailId).clear();
        driver.findElement(billingemailId).sendKeys(email);
        return this;
    }
    public CheckoutPage clickOnPlaceOrder()
    {
        driver.findElement(placeorderBtn).click();
        return this;
    }
    public String getNotice()
    {
        return driver.findElement(successnotice).getText();
    }

    public CheckoutPage setBillingAddress(BillingAddress billingAddress)
    {
        return enterFirstName(billingAddress.getFirstName()).
                enterLastName(billingAddress.getLastName()).
                enterAddressLineOne(billingAddress.getAddressLineOne()).
                enterCity(billingAddress.getCity()).
                enterPostCode(billingAddress.getPostalCode()).
                enterEmailId(billingAddress.getEmail());
    }
}
