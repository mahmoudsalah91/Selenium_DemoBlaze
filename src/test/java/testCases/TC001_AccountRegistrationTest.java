package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageOpajects.HomePage;
import pageOpajects.RegistrationPage;
import testBase.BaseClass;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class TC001_AccountRegistrationTest extends BaseClass {
    public   String PROPERTIES_FILE = "src/test/resources/validLoginData.properties";
    public static String userName = randomString();
    public static  String password = randomNumber();
    String accualConfirmMessage;
    String expectedSuccessfulMessage = "Sign up successful.";

    @Test
    public void registerTest () {
        HomePage home = new HomePage(driver);
        home.ClickSignupBtn();
        RegistrationPage register = new RegistrationPage(driver);
        register.setUserName(userName);
        register.setPassword(password);
        saveCredentialToProperties(userName,password);
        register.clickSignUpBtn();
        accualConfirmMessage = register.confirmMessage();
        Assert.assertEquals(accualConfirmMessage,expectedSuccessfulMessage);
    }


    private void saveCredentialToProperties(String username,String password) {
        Properties properties = new Properties();
        try (OutputStream output = new FileOutputStream(PROPERTIES_FILE)) {
            properties.setProperty("username", username);
            properties.setProperty("password", password);
            properties.store(output, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @AfterTest
    void tearDown(){
        driver.quit();
    }
}
