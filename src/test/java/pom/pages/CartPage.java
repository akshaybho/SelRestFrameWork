package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.base.BasePage;

public class CartPage extends BasePage {

    private final By productName = By.cssSelector("td[class='product-name'] a");
    private final By checkoutbtn = By.cssSelector(".checkout-button");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName()
    {
        return driver.findElement(productName).getText();
    }

    public CheckoutPage clickCheckOutBtn()
    {
        driver.findElement(checkoutbtn).click();
        return new CheckoutPage(driver);
    }

}
