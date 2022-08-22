package TestRunner;

import Base.SetUp;
import Pages.LoginPage;
import Utils.Utils;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestRunner extends SetUp {

    LoginPage loginPage;
    Utils utils;

    @Test(priority = 2)
    public void doValidLogin() throws IOException, ParseException {
        driver.get("http://automationpractice.com/");
        loginPage = new LoginPage(driver);
        utils = new Utils();
        utils.getUserCreds(utils.getLastUser());
        boolean isLogoutFound = loginPage.doLoginWithValidCreds(utils.getEmail(), utils.getPassword());
        Assert.assertEquals(isLogoutFound , true);
        loginPage.linkLogout.click();
    }

    @Test(priority = 1)
    public void inValidLogin() throws IOException, ParseException {
        driver.get("http://automationpractice.com/");
        loginPage = new LoginPage(driver);
        utils = new Utils();
        utils.getUserCreds(1);
        String invalidMessage = loginPage.doLoginWithInvalidPassword(utils.getEmail(), utils.getPassword());
        Assert.assertTrue(invalidMessage.contains("Invalid"));
    }
}
