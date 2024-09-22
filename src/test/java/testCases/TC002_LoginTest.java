package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageOpajects.HomePage;
import pageOpajects.LoginPage;
import testBase.BaseClass;
import utilities.FileUtility;

public class TC002_LoginTest extends BaseClass {

    String validUserName= FileUtility.getFile("validLoginData").getString("username");
    String validPassword=  FileUtility.getFile("validLoginData").getString("password");
    String accualUserLogin;

    @Test
    public void validLoginTest()
    {
        HomePage home = new HomePage(driver);
        home.ClickLoginBtn();
        LoginPage login = new LoginPage(driver);
        login.setUserName(validUserName);
        login.setPassword(validPassword);
        login.clickLoginBtn();
        accualUserLogin=login.verifyUserLogin();
        System.out.println(accualUserLogin);
       Assert.assertEquals(accualUserLogin,"Welcome "+validUserName);


    }
}
