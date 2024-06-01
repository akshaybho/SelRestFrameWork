import org.testng.Assert;
import org.testng.annotations.Test;
import pom.base.BaseTest;
import pom.objects.BillingAddress;
import pom.objects.Product;
import pom.pages.CartPage;

import pom.pages.CheckoutPage;
import pom.pages.HomePage;
import pom.pages.StorePage;
import utilities.Utils;

import java.io.IOException;
import java.io.InputStream;

public class MyFirstTestCase extends BaseTest {

    @Test
    public void guestCheckout() throws InterruptedException, IOException {

        BillingAddress billingAddress = Utils.deserializeJson("myBillingAddress.json", BillingAddress.class);

        Product pro = new Product(1215);
        /*BillingAddress billingAddress = new BillingAddress().
        setFirstName("demo").
        setLastName("user").
        setAddressLineOne("San Francisco").
        setCity("San Francisco").
        setPostalCode("94188").
        setEmail("askomdch@gmail.com");*/

        //BillingAddress billingAddress = new BillingAddress("demo", "user", "San Francisco", "San Francisco", "94188", "askomdch@gmail.com");

        StorePage storePage = new HomePage(driver).
                load().
                clickStoreMenuLink().
                search("Blue");
        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");

        storePage.clickAddToCartBtn(pro.getName());
        Thread.sleep(5000);
        CartPage cartPage = storePage.clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), pro.getName());

        CheckoutPage checkoutPage = cartPage.
                clickCheckOutBtn().
               setBillingAddress(billingAddress).
                clickOnPlaceOrder();
        Thread.sleep(5000);
        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");


    }

}
