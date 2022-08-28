package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage {
    @FindBy(id = "search_query_top")
    WebElement txtSearch;
    @FindBy(name = "submit_search")
    WebElement btnSearch;
    @FindBy(className = "heading-counter")
    WebElement lblResult;
    @FindBy(tagName = "img")
    List<WebElement> imgProduct;
    @FindBy(xpath = "//span[contains(text(),'Add to cart')]")
    WebElement btnAddCart;
    @FindBy(css = "[title = 'Proceed to checkout']")
    WebElement btnCheckOut;
    @FindBy(id = "cart_title")
    WebElement lblCartSummaryTitle;
    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/p[2]/a[1]")
    WebElement btnCheckOut1;
    @FindBy(xpath = "//h1[contains(text(),'Addresses')]")
    WebElement lblAddress;
    @FindBy(css = "[type = 'submit']")
    List<WebElement> btnSubmit;
    @FindBy(xpath = "//h1[contains(text(),'Shipping')]")
    WebElement lblShipping;
    @FindBy(id = "cgv")
    WebElement checkbox;
    @FindBy(name = "processCarrier")
    WebElement btnSubmit1;
    @FindBy(xpath = "//h1[contains(text(),'Please choose your payment method')]")
    WebElement lblPaymentMethod;
    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]")
    WebElement btnPaymentOption;
    @FindBy(className = "page-heading")
    WebElement lblOrderSummary;
    @FindBy(css = "[type = 'submit']")
    List<WebElement> btnConfirmOrder;
    @FindBy(className = "dark")
    List<WebElement> lblOrderComplete;
    WebDriver driver;
    public OrderPage(WebDriver driver){
        this.driver =driver;

        PageFactory.initElements(driver , this);
    }

    public String searchProduct(String product){
        txtSearch.sendKeys(product);
        btnSearch.click();
        return lblResult.getText();
    }

    public boolean chooseProduct(){
        imgProduct.get(14).click();
        return btnAddCart.isDisplayed();
    }

    public boolean addToCart(){
        btnAddCart.click();
        return btnCheckOut.isDisplayed();
    }

    public String clickOnCheckout(){
        btnCheckOut.click();
        return lblCartSummaryTitle.getText();
    }

    public String clickOnCheckout1() throws InterruptedException {
        btnCheckOut1.click();
        Thread.sleep(2000);
        return lblAddress.getText();
    }

    public String submitBtnClick(){
        btnSubmit.get(1).click();
        return lblShipping.getText();
    }

    public void clickOnCheckBox(){
        checkbox.click();
    }

    public String submitBtnClick1(){
        btnSubmit1.click();
        return lblPaymentMethod.getText();
    }

    public String paymentOption(){
        btnPaymentOption.click();
        return lblOrderSummary.getText();
    }

    public String clickConfirmBtn(){
        btnConfirmOrder.get(1).click();
        return lblOrderComplete.get(5).getText();
    }
}
