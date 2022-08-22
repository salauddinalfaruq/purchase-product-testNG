package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignupPage {
    @FindBy(id = "email_create")
    WebElement txtRegEmail;
    @FindBy(id = "SubmitCreate")
    WebElement btnSignup;
    @FindBy(id = "id_gender1")
    WebElement rb1;
    @FindBy(id = "customer_firstname")
    WebElement txtFirstName;
    @FindBy(id = "customer_lastname")
    WebElement txtLastName;
    @FindBy(id = "passwd")
    WebElement txtPassword;
    @FindBy(id = "days")
    WebElement cbDays;
    @FindBy(id = "months")
    WebElement cbMonths;
    @FindBy(id = "years")
    WebElement cbYears;
    @FindBy(id = "address1")
    WebElement txtAddress1;
    @FindBy(id = "city")
    WebElement txtCity;
    @FindBy(id = "id_state")
    WebElement cbState;
    @FindBy(id = "postcode")
    WebElement txtPostCode;
    @FindBy(id = "phone_mobile")
    WebElement txtMobile;
    @FindBy(id = "submitAccount")
    WebElement btnSubmitAccount;

    WebDriver driver;
    public SignupPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver , this);
    }

    public void doRegistration(String email , String password , String mobile ) throws InterruptedException {
        txtRegEmail.sendKeys(email);
        btnSignup.click();
        Thread.sleep(3000);
        rb1.click();
        txtFirstName.sendKeys("Shahriar");
        txtLastName.sendKeys("Sadi");
        txtPassword.sendKeys(password);
        Select days = new Select(cbDays);
        days.selectByValue("1");
        Select months = new Select(cbMonths);
        months.selectByValue("6");
        Select years = new Select(cbYears);
        years.selectByValue("2005");
        txtAddress1.sendKeys("1, Manhatton, NewYork");
        txtCity.sendKeys("NewYork");
        Select state = new Select(cbState);
        state.selectByValue("32");
        txtPostCode.sendKeys("10102");
        txtMobile.sendKeys(mobile);
        btnSubmitAccount.click();
    }
}
