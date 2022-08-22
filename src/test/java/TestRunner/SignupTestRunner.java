package TestRunner;

import Base.SetUp;
import Pages.LoginPage;
import Pages.SignupPage;
import Utils.Utils;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class SignupTestRunner extends SetUp {

    @Test
    public void doSignup() throws InterruptedException, IOException, ParseException {
        driver.get("http://automationpractice.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.linkLogin.click();
        SignupPage signupPage = new SignupPage(driver);
        Utils utils = new Utils();
        String signupEmail = "testautouser" + utils.generateRandomNumber(10000, 99999);
        String email = signupEmail + "@test.com";
        String password = utils.generateRandomPassword(8);
        String mobile = "175" + utils.generateRandomNumber(1000000, 9999999);
        signupPage.doRegistration(email, password, mobile);
        utils.writeUserInfo(email, password);
    }
}
