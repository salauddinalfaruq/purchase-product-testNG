package TestRunner;

import Base.SetUp;
import Pages.LoginPage;
import Pages.OrderPage;
import Utils.Utils;
import com.beust.ah.A;
import io.qameta.allure.Allure;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class OrderTestRunner extends SetUp {

    LoginPage loginPage;
    Utils utils;
    OrderPage orderPage;

    @Test(priority = 1, description = "User Login")
    public void doLogin() throws IOException, ParseException {
        driver.get("http://automationpractice.com/");
        loginPage = new LoginPage(driver);
        utils = new Utils();
        utils.getUserCreds(utils.getLastUser());
        loginPage.doLoginWithValidCreds(utils.getEmail(), utils.getPassword());
    }

    @Test(priority = 2 , description = "User can search product")
    public void searchProduct(){
        driver.get("http://automationpractice.com/");
        orderPage = new OrderPage(driver);
        String txtResult = orderPage.searchProduct("dress");
        Assert.assertTrue(txtResult.contains("results have been found"));
        Allure.description("User search product successfully");
    }

    @Test(priority = 3 , description = "User can choose product")
    public void chooseProduct(){
        orderPage = new OrderPage(driver);
        boolean found = orderPage.chooseProduct();
        Assert.assertTrue(found);
        Allure.description("User can choose product from product list");
    }

    @Test(priority = 4 , description = "User can add product to cart")
    public void addToCart(){
        orderPage = new OrderPage(driver);
        boolean found = orderPage.addToCart();
        // Assert.assertTrue(found);
        Allure.description("Product added to cart");
    }

    @Test(priority = 5 , description = "User can see product summary")
    public void productSummary(){
        orderPage = new OrderPage(driver);
        String txtProductSummary = orderPage.clickOnCheckout();
        Assert.assertTrue(txtProductSummary.contains("SHOPPING-CART SUMMARY"));
        Allure.description("User can view product summary before checkout");
    }

    @Test(priority = 6 , description = "User see product summary")
    public void addressPage() throws InterruptedException {
        orderPage = new OrderPage(driver);
        String txtAddress = orderPage.clickOnCheckout1();
        Assert.assertTrue(txtAddress.contains("ADDRESSES"));
        Allure.description("User can view summary before checkout");
    }

    @Test(priority = 7 , description = "User click on submit button")
    public  void submitClick(){
        orderPage = new OrderPage(driver);
        String txtShipping = orderPage.submitBtnClick();
        Assert.assertTrue(txtShipping.contains("SHIPPING"));
        Allure.description("Click on submit button successfully");
    }

    @Test(priority = 8 , description = "User should click on checkbox")
    public void checkBoxClick(){
        orderPage = new OrderPage(driver);
        orderPage.clickOnCheckBox();
        Allure.description("User click on checkbox successfully");
    }

    @Test(priority = 9 , description = "User click on submit button and go to payment method")
    public void submitClick1(){
        orderPage = new OrderPage(driver);
        String txtPaymentMethod = orderPage.submitBtnClick1();
        Assert.assertTrue(txtPaymentMethod.contains("PLEASE CHOOSE YOUR PAYMENT METHOD"));
        Allure.description("User click on submit button successfully and go to payment method page");
    }

    @Test(priority = 10 , description = "User can see payment option and choose payment method")
    public void payOption(){
        orderPage = new OrderPage(driver);
        String txtOrderSummary = orderPage.paymentOption();
        Assert.assertTrue(txtOrderSummary.contains("ORDER SUMMARY"));
        Allure.description("User choose payment method successfully");
    }

    @Test(priority = 11 , description = "User click on confirm button")
    public void orderConfirmation(){
        orderPage = new OrderPage(driver);
        String txtOrderConfirm = orderPage.clickConfirmBtn();
        System.out.println("\n" +txtOrderConfirm);
        Assert.assertTrue(txtOrderConfirm.contains("Your order on My Store is complete."));
        Allure.description("User click on confirm button successfully and see the confirmation message");
    }
}
